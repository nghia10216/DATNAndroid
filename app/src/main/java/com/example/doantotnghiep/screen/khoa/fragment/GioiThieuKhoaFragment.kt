package com.example.doantotnghiep.screen.khoa.fragment

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.DonViHopTac
import com.example.doantotnghiep.data.model.HinhAnhKhoa
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.screen.khoa.adapter.HopTacAdapter
import com.example.doantotnghiep.screen.khoa.adapter.SliderAdapterKhoa
import com.example.doantotnghiep.untils.Constant
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_gioi_thieu_khoa.*


class GioiThieuKhoaFragment : Fragment(){

    private var adapter: SliderAdapterKhoa? = null
    private val adapterHopTac: HopTacAdapter by lazy { HopTacAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gioi_thieu_khoa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }
    private fun initView() {
        hoptacRecyclerView.setHasFixedSize(true)
        hoptacRecyclerView.adapter = adapterHopTac
        hoptacRecyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )


        adapter = SliderAdapterKhoa()
        adapter?.let { imageSlider.setSliderAdapter(it) }
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider.indicatorSelectedColor = Color.WHITE
        imageSlider.indicatorUnselectedColor = Color.GRAY
        imageSlider.scrollTimeInSec = 3
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()

    }
    private fun initData() {
        val bundle = this.arguments
        if (bundle != null) {
            val khoa = bundle.getSerializable("thongTinKhoa") as Khoa
            val hinhanhs = khoa.hinhanhkhoa as MutableList<HinhAnhKhoa>?
            hinhanhs?.let { adapter?.renewItems(it) }
            Picasso.get().load(Constant.BASE_URL_IMAGE_LOGO_KHOA + khoa.logoKhoa).into(
                logoKhoaImageView
            )
            adapterHopTac.updateData(khoa.donvihoptac as MutableList<DonViHopTac>?)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                gioithieukhoaTextView.text = Html.fromHtml(
                    khoa.gioiThieuKhoa,
                    Html.FROM_HTML_MODE_COMPACT
                )
            } else {
                gioithieukhoaTextView.text = Html.fromHtml(khoa.gioiThieuKhoa)
            }

            mailImageView.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "plain/text"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(khoa.email))
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                intent.putExtra(Intent.EXTRA_TEXT, "mail body")
                startActivity(Intent.createChooser(intent, ""))
            }
            phoneImageView.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(khoa.sDT)))
                startActivity(intent)
            }

        }


    }

}