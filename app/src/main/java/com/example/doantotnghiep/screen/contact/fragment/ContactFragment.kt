package com.example.doantotnghiep.screen.contact.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.hoidap.HoiDapRepository
import com.example.doantotnghiep.data.source.khoa.KhoaRepository
import com.example.doantotnghiep.data.source.remote.HoiDapRemoteDataSource
import com.example.doantotnghiep.data.source.remote.KhoaRemoteDataSource
import com.example.doantotnghiep.screen.contact.adapter.HoiDapAdapter
import com.example.doantotnghiep.screen.khoa.adapter.KhoaAdapter
import com.example.doantotnghiep.screen.khoa.fragment.ChiTietKhoaFragment
import com.example.doantotnghiep.screen.khoa.fragment.KhoaContract
import com.example.doantotnghiep.screen.khoa.fragment.KhoaPresenter
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_khoa.*
import java.util.*

class ContactFragment : Fragment(), HoiDapContract.View, OnItemRecyclerViewClickListener<HoiDap> {
    private var hoidapPresenter: HoiDapContract.Presenter? = null
    private val adapter: HoiDapAdapter by lazy { HoiDapAdapter() }
    var email: String = ""
    var password: String = ""
    var idUser = -1

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

    override fun onGetHoiDapSuccess(data: MutableList<HoiDap>) {
        adapter.updateData(data)
    }

    override fun onError(error: String) {
        Toast.makeText(context, "Looix", Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        hoidapRecycleView.adapter = adapter
        staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        hoidapRecycleView.layoutManager = staggeredGridLayoutManager
        adapter.registerItemRecyclerViewClickListener(this)

    }

    private fun initData() {
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
            email?.let { password?.let { it1 -> hoidapPresenter?.getHoiDap(it, it1, idUser) } }
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
    }

    override fun onItemClickListener(item: HoiDap?) {
        Toast.makeText(context, item?.cauHoi, Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClickListener(item: HoiDap?) {
        TODO("Not yet implemented")
    }

//    private fun openFragment(fragment: Fragment, item: HoiDap?) {
//        val bundle = Bundle()
//        bundle.putSerializable("hoidap", item)
//        fragment.arguments = bundle
//        activity?.supportFragmentManager
//            ?.beginTransaction()
//            ?.replace(R.id.fragment_container, fragment)
//            ?.addToBackStack(null)
//            ?.commit()
//    }



}

