package com.example.doantotnghiep.screen.bomon

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.BoMon
import com.example.doantotnghiep.data.model.HinhAnhNganh
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.screen.nganh.fragment.CongViecVaNoiLamViecFragment
import com.example.doantotnghiep.screen.nganh.fragment.GioiThieuNganhFragment
import kotlinx.android.synthetic.main.fragment_bomon.*
import kotlinx.android.synthetic.main.fragment_gioi_thieu_khoa.*
import kotlinx.android.synthetic.main.fragment_gioi_thieu_nganh.*
import kotlinx.android.synthetic.main.fragment_gioi_thieu_nganh.tennganhTextView
import kotlinx.android.synthetic.main.fragment_nganh.*

class BomonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bomon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val boMon = bundle.getSerializable("bomon") as BoMon
            tenbomonTextView.text = boMon.tenBoMon
            tenbomonTextView.isSelected = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                gioithieubomonTextView.text = Html.fromHtml(boMon.gioiThieuBoMon, Html.FROM_HTML_MODE_COMPACT)
            } else {
                gioithieubomonTextView.text = Html.fromHtml(boMon.gioiThieuBoMon)
            }

        }
    }
}