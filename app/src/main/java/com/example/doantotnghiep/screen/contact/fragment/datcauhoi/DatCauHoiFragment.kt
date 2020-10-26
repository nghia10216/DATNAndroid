package com.example.doantotnghiep.screen.contact.fragment.datcauhoi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.source.hoidap.HoiDapRepository
import com.example.doantotnghiep.data.source.remote.HoiDapRemoteDataSource
import com.example.doantotnghiep.screen.contact.fragment.ContactFragment
import kotlinx.android.synthetic.main.fragment_dat_cau_hoi.*


class DatCauHoiFragment : Fragment(), DatCauHoiContract.View {

    private var datcauhoiPresenter: DatCauHoiContract.Presenter? = null
    var email: String = ""
    var password: String = ""
    var idUser = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dat_cau_hoi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        topAppBar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun initData() {

        datcauhoiPresenter = context?.let {
            DatCauHoiPresenter(
                HoiDapRepository.getInstance(HoiDapRemoteDataSource.getInstance()),
                this
            )
        }
    }

    override fun onSucces(data: HoiDap) {
        openFragment(ContactFragment())
        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show()
    }

    override fun onError(error: String) {
        openFragment(ContactFragment())
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                val bundle = this@DatCauHoiFragment.arguments
                if (bundle != null) {
                    email = bundle.getString("email").toString()
                    password = bundle.getString("password").toString()
                    idUser = bundle.getInt("idUser")
                    val cauhoi = cauhoiTextField.editText?.text.toString()
                    if (cauhoi.isNotEmpty()) {
                        email.let {
                            password.let { it1 ->
                                datcauhoiPresenter?.postCauHoi(
                                    it,
                                    it1, cauhoi, idUser
                                )
                            }
                        }
                    } else {
                        openFragment(ContactFragment())
                    }
                }

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            callback
        )
    }

    private fun openFragment(fragment: Fragment) {
        val bundle1 = Bundle()
        val fragment = ContactFragment()
        bundle1.putInt("idUser", idUser)
        bundle1.putString("email", email)
        bundle1.putString("password", password)
        fragment.arguments = bundle1
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()

    }


}

