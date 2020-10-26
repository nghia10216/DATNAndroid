package com.example.doantotnghiep.screen.nganh.fragment

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import kotlinx.android.synthetic.main.fragment_cong_viec_va_noi_lam_viec.*


class CongViecVaNoiLamViecFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cong_viec_va_noi_lam_viec, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val nganh = bundle.getSerializable("nganh") as Nganh
            congviecvanoilamviecTextView.movementMethod = ScrollingMovementMethod()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                congviecvanoilamviecTextView.text = Html.fromHtml(
                    nganh.congViecVaNoiLamViec,
                    Html.FROM_HTML_MODE_COMPACT
                )
            } else {
                congviecvanoilamviecTextView.text = Html.fromHtml(nganh.congViecVaNoiLamViec)
            }
        }
    }
}