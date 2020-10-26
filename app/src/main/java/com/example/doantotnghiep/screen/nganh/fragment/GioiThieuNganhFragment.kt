package com.example.doantotnghiep.screen.nganh.fragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HinhAnhNganh
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.screen.khoa.adapter.HopTacAdapter
import com.example.doantotnghiep.screen.khoa.adapter.SliderAdapterKhoa
import com.example.doantotnghiep.screen.nganh.adapter.SliderAdapterNganh
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_gioi_thieu_khoa.*
import kotlinx.android.synthetic.main.fragment_gioi_thieu_nganh.*

class GioiThieuNganhFragment : Fragment() {
    private val adapter: SliderAdapterNganh by lazy { SliderAdapterNganh() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gioi_thieu_nganh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val nganh = bundle.getSerializable("nganh") as Nganh
            tennganhTextView.isSelected = true
            tennganhTextView.text = nganh.tenNganh
            adapter.renewItems(nganh.hinhanhnganh as MutableList<HinhAnhNganh>)
            manganhgtTextView.text = nganh.maNganh
            bangtotnghiepgtTextView.text = nganh.bangTotNghiep
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                gioithieunganhgtTextView.text = Html.fromHtml(nganh.gioiThieuNganh, Html.FROM_HTML_MODE_COMPACT)
            } else {
                gioithieunganhgtTextView.text = Html.fromHtml(nganh.gioiThieuNganh)
            }
        }
    }

    private fun initView() {
        adapter.let { imageNganhSlider.setSliderAdapter(it) }
        imageNganhSlider.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageNganhSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageNganhSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageNganhSlider.indicatorSelectedColor = Color.WHITE
        imageNganhSlider.indicatorUnselectedColor = Color.GRAY
        imageNganhSlider.scrollTimeInSec = 3
        imageNganhSlider.isAutoCycle = true
        imageNganhSlider.startAutoCycle()
    }
}