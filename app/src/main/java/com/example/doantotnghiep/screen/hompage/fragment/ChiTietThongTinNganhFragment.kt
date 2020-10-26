package com.example.doantotnghiep.screen.hompage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.screen.nganh.fragment.NganhFragment
import com.example.doantotnghiep.untils.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_chi_tiet_thong_tin_nganh.*



class ChiTietThongTinNganhFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi_tiet_thong_tin_nganh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        val bundle = this.arguments
        if (bundle != null) {
            val thongTinNganh = bundle.getSerializable("thongTinNganh") as ThongTinNganh
            Picasso.get().load(Constant.BASE_URL_IMAGE + thongTinNganh.anhGioiThieu)
                .into(thongtinnganhImageView)
            tennganhTextView.text = thongTinNganh.nganh?.tenNganh
            manganhTextView.text = thongTinNganh.nganh?.maNganh
            trinhdodaotaoTextView.text = thongTinNganh.trinhDoDaoTao
            hinhthucdaotaoTextView.text = thongTinNganh.hinhThucDaoTao
            thoigiandaotaoTextView.text = thongTinNganh.thoiGianDaoTao
            thoigiantuyensinhvanophopsoTextView.text = thongTinNganh.thoiGianTuyenSinhNopHoSo
            thoigianxettuyenvanhaphocTextView.text = thongTinNganh.thoiGianXetTuyenVaNhapHoc
            hinhthuctuyensinhTextView.text = thongTinNganh.hinhThucTuyenSinh
            tohopmonxettuyenTextView.text = thongTinNganh.toHopMonXetTuyen
            diemchuanTextView.text = thongTinNganh.diemChuanCacNam
            chitieuTextView.text = thongTinNganh.chiTieu
            hocphiTextView.text = thongTinNganh.hocPhi

            xemthemButton.setOnClickListener {
                openFragment(NganhFragment(),thongTinNganh.nganh, 1)
            }

        }
    }

    private fun openFragment(fragment: Fragment, nganh: Nganh?, idSwitch: Int) {

        val bundle = Bundle()
        bundle.putSerializable("nganh", nganh)
        bundle.putInt("key", idSwitch)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}