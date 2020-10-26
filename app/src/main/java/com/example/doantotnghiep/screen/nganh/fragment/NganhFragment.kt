package com.example.doantotnghiep.screen.nganh.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.untils.Constant
import kotlinx.android.synthetic.main.fragment_nganh.*
import java.io.File
import java.io.FileOutputStream
import java.net.URL


class NganhFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nganh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        val bundle = this.arguments
        if (bundle != null) {
            val nganh = bundle.getSerializable("nganh") as Nganh
            val id = bundle.getInt("key", 0)
            tennganhTextView.text = nganh.tenNganh
            tennganhTextView.isSelected = true
            gioithieunganhCardView.setOnClickListener {
                if (id == 1) {
                    openFragment(R.id.fragment_container, GioiThieuNganhFragment(), nganh)
                } else
                    openFragment(R.id.homeFrameLayout, GioiThieuNganhFragment(), nganh)
            }
            congviecvanoilamviecCardView.setOnClickListener {
                if (id == 1) {
                    openFragment(R.id.fragment_container, CongViecVaNoiLamViecFragment(), nganh)
                } else
                    openFragment(R.id.homeFrameLayout, CongViecVaNoiLamViecFragment(), nganh)
            }

            khungchuongtrinhdaotaoCardView.setOnClickListener {
                if (nganh.khungChuongTrinhDaoTao.isNullOrEmpty()) {
                    Toast.makeText(context, "Chưa có", Toast.LENGTH_SHORT).show()
                } else {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constant.BASE_URL_KHUNGDAOTAO + nganh.khungChuongTrinhDaoTao))
                    startActivity(browserIntent)
                }

            }
        }
    }

    private fun openFragment(viewId: Int, fragment: Fragment, data: Nganh?) {
        val bundle = Bundle()
        bundle.putSerializable("nganh", data)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(viewId, fragment)
            ?.addToBackStack(null)
            ?.commit()
//        drawerLayout.closeDrawer(GravityCompat.START)
    }


    fun String.saveTo(path: String) {
        URL(this).openStream().use { input ->
            FileOutputStream(File(path)).use { output ->
                input.copyTo(output)
            }
        }
    }

}