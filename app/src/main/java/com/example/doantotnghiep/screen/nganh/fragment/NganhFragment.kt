package com.example.doantotnghiep.screen.nganh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import kotlinx.android.synthetic.main.fragment_login_success.*
import kotlinx.android.synthetic.main.fragment_nganh.*


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
                Toast.makeText(context, "chưa", Toast.LENGTH_SHORT).show()
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

}