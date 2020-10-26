package com.example.doantotnghiep.screen.khoa.fragment


import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.*
import com.example.doantotnghiep.screen.bomon.BomonFragment
import com.example.doantotnghiep.screen.khoa.adapter.BomonNganhAdapter
import com.example.doantotnghiep.screen.khoa.adapter.KhoaAdapter
import com.example.doantotnghiep.screen.khoa.adapter.NganhBomonAdapter
import com.example.doantotnghiep.screen.nganh.fragment.NganhFragment
import com.example.doantotnghiep.untils.Constant
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_gioi_thieu_khoa.*
import kotlinx.android.synthetic.main.fragment_khoa.*
import kotlinx.android.synthetic.main.fragment_nganh_bomon.*

class NganhBomonFragment : Fragment() {
    private val adapterNganh: NganhBomonAdapter by lazy { NganhBomonAdapter() }
    private val adapterBomon: BomonNganhAdapter by lazy { BomonNganhAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nganh_bomon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        nganhbomonRecyclerView.setHasFixedSize(true)
        nganhbomonRecyclerView.adapter = adapterNganh
        nganhbomonRecyclerView.layoutManager = LinearLayoutManager(context)
        adapterNganh.registerItemRecyclerViewClickListener(object :
            OnItemRecyclerViewClickListener<Nganh> {
            override fun onItemClickListener(item: Nganh?) {
                openFragment(NganhFragment(), item)
            }

        })

        bomonnganhRecyclerView.setHasFixedSize(true)
        bomonnganhRecyclerView.adapter = adapterBomon
        bomonnganhRecyclerView.layoutManager = LinearLayoutManager(context)
        adapterBomon.registerItemRecyclerViewClickListener(object :
            OnItemRecyclerViewClickListener<BoMon> {
            override fun onItemClickListener(item: BoMon?) {
                openBomonFragment(BomonFragment(), item)
            }

        })
    }

    private fun openFragment(fragment: Fragment, data: Nganh?) {
        val bundle = Bundle()
        bundle.putSerializable("nganh", data)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.homeFrameLayout, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
    private fun openBomonFragment(fragment: Fragment, data: BoMon?) {
        val bundle = Bundle()
        bundle.putSerializable("bomon", data)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.homeFrameLayout, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val khoa = bundle.getSerializable("thongTinKhoa") as Khoa
            Log.d("khoane", khoa.nganh?.get(0)?.tenNganh.toString())
            adapterNganh.updateData(khoa.nganh as MutableList<Nganh>?)
            adapterBomon.updateData(khoa.bomon as MutableList<BoMon>?)
        } else {
            Log.d("ketqua", "null ne")
        }
    }

}