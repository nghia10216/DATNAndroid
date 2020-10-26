package com.example.doantotnghiep.screen.khoa.fragment


import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HinhAnhKhoa

import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.khoa.KhoaRepository
import com.example.doantotnghiep.data.source.remote.KhoaRemoteDataSource
import com.example.doantotnghiep.screen.khoa.adapter.KhoaAdapter

import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_khoa.*


class KhoaFragment : Fragment(), KhoaContract.View, OnItemRecyclerViewClickListener<Khoa> {
    private var khoaPresenter: KhoaContract.Presenter? = null

    private val adapter: KhoaAdapter by lazy { KhoaAdapter() }
    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_khoa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()
        initView()
        initData()
        khoaPresenter?.getThongTinKhoa()

    }

    private fun initView() {
        progressDialog = ProgressDialog(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.registerItemRecyclerViewClickListener(this)

    }

    private fun initData() {
        progressDialog?.show()
        khoaPresenter = context?.let {
            KhoaPresenter(
                KhoaRepository.getInstance(KhoaRemoteDataSource.getInstance()),
                this
            )
        }

    }

    override fun onSuccess(data: MutableList<Khoa>) {
        progressDialog?.dismiss()
        toolbar.title = data[1].tenKhoa
        adapter.updateData(data)
        val fragment = ChiTietKhoaFragment()
        val bundle = Bundle()
        bundle.putSerializable("thongTinKhoa", data[1])
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.homeFrameLayout, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }


    override fun onError(error: String) {
        progressDialog?.dismiss()
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun initNavigation() {
        val toggle = ActionBarDrawerToggle(
            activity,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onItemClickListener(item: Khoa?) {
        toolbar.title = item?.tenKhoa
        openFragment(ChiTietKhoaFragment(), data = item)
    }
    private fun openFragment(fragment: Fragment, data: Khoa?) {
        val bundle = Bundle()
        bundle.putSerializable("thongTinKhoa", data)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.homeFrameLayout, fragment)
            ?.addToBackStack(null)
            ?.commit()
        drawerLayout.closeDrawer(GravityCompat.START)
    }

}

