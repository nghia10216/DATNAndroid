package com.example.doantotnghiep.screen.contact.fragment

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HoiDap
import kotlinx.android.synthetic.main.fragment_chi_tiet_hoi_dap.*



class ChiTietHoiDapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi_tiet_hoi_dap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        chitietcauhoiTopAppBar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val hoidap = bundle.getSerializable("hoidap") as HoiDap
            cauhoiTextView.movementMethod = ScrollingMovementMethod()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cauhoiTextView.text = Html.fromHtml(
                    hoidap.cauHoi,
                    Html.FROM_HTML_MODE_COMPACT
                )
            } else {
                cauhoiTextView.text = Html.fromHtml(hoidap.cauHoi)
            }

            cautraloiTextView.movementMethod = ScrollingMovementMethod()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cautraloiTextView.text = Html.fromHtml(
                    hoidap.cauTraLoi,
                    Html.FROM_HTML_MODE_COMPACT
                )
            } else {
                cautraloiTextView.text = Html.fromHtml(hoidap.cauTraLoi)
            }
        }
    }


}