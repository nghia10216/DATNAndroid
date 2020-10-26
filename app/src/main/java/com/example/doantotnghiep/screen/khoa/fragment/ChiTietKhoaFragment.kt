package com.example.doantotnghiep.screen.khoa.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.screen.khoa.adapter.KhoaViewpagerAdapter
import com.example.doantotnghiep.screen.khoa.adapter.SliderAdapterKhoa
import kotlinx.android.synthetic.main.fragment_chi_tiet_khoa.*


class ChiTietKhoaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi_tiet_khoa, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAdapter()
        initData()
    }

    private fun initViewPagerAdapter() {
        khoaViewpager.adapter = context?.let { KhoaViewpagerAdapter(childFragmentManager, it) }
        khoaTabLayout.setupWithViewPager(khoaViewpager)
    }
    private fun getFragmentInsideViewPager(position: Int = khoaViewpager.currentItem) =
        khoaViewpager.adapter?.instantiateItem(khoaViewpager, position) as? Fragment
    private fun getOtherFragmentInsideViewPager(position: Int = khoaViewpager.currentItem) =
        khoaViewpager.adapter?.instantiateItem(khoaViewpager, position +1) as? Fragment

    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val khoa = bundle.getSerializable("thongTinKhoa") as Khoa
            val bundle1 = Bundle()
            bundle1.putSerializable("thongTinKhoa", khoa)
            val fragment1 = getFragmentInsideViewPager()
            val fragment2 = getOtherFragmentInsideViewPager()
            fragment1?.arguments = bundle1
            fragment2?.arguments = bundle1
        }
    }
}