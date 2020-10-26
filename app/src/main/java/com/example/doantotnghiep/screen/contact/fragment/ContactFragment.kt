package com.example.doantotnghiep.screen.contact.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.source.hoidap.HoiDapRepository
import com.example.doantotnghiep.data.source.remote.HoiDapRemoteDataSource
import com.example.doantotnghiep.screen.contact.adapter.HoiDapAdapter
import com.example.doantotnghiep.screen.contact.fragment.datcauhoi.DatCauHoiFragment
import com.example.doantotnghiep.screen.login.LoginParentFragment
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_contact.*


class ContactFragment : Fragment(), HoiDapContract.View, OnItemRecyclerViewClickListener<HoiDap> {
    private var hoidapPresenter: HoiDapContract.Presenter? = null
    private val adapter: HoiDapAdapter by lazy { HoiDapAdapter() }
    var email: String = ""
    var password: String = ""
    var idUser = -1
    private var progressDialog: ProgressDialog? = null
    var listHoiDap:MutableList<HoiDap>? = null


    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()

    }



    override fun xoaCauHoiSucces() {
        Toast.makeText(context, "thanh cong", Toast.LENGTH_SHORT).show()
    }

    override fun onGetHoiDapSuccess(data: MutableList<HoiDap>) {
        listHoiDap = data
        progressDialog?.dismiss()
        adapter.updateData(data)

    }

    override fun onError(error: String) {
        progressDialog?.dismiss()
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        progressDialog = ProgressDialog(context)
        hoidapRecycleView.adapter = adapter
        staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        hoidapRecycleView.layoutManager = staggeredGridLayoutManager
        adapter.registerItemRecyclerViewClickListener(this)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(hoidapRecycleView)



    }

    private fun initData() {
        listHoiDap = mutableListOf()
        progressDialog?.show()
        hoidapPresenter = context?.let {
            HoiDapPresenter(
                HoiDapRepository.getInstance(HoiDapRemoteDataSource.getInstance()),
                this
            )
        }

        val bundle = this.arguments
        if (bundle != null) {
            email = bundle.getString("email").toString()
            password = bundle.getString("password").toString()
            idUser = bundle.getInt("idUser")
            email.let { password.let { it1 -> hoidapPresenter?.getHoiDap(it, it1, idUser) } }
        }
        extended_fab.setOnClickListener {
            val bundle1 = Bundle()
            val fragment = DatCauHoiFragment()
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

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout -> {
                    addFragment(LoginParentFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun addFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
    override fun onItemClickListener(item: HoiDap?) {
        openFragment(ChiTietHoiDapFragment(), item)
    }

    private fun openFragment(fragment: Fragment, item: HoiDap?) {
        val bundle = Bundle()
        bundle.putSerializable("hoidap", item)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
    private val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val possition = viewHolder.adapterPosition
            val hoiDap = listHoiDap?.get(possition)
            hoiDap?.id?.let { hoidapPresenter?.xoaCauHoi(email, password, it) }
            if (hoiDap != null) {
                listHoiDap?.remove(hoiDap)
            }
            adapter.updateData(listHoiDap)
        }

    }


}

