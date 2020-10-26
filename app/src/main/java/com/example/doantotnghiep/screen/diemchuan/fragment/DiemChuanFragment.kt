package com.example.doantotnghiep.screen.diemchuan.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.data.source.diemchuan.DiemChuanRepository
import com.example.doantotnghiep.data.source.remote.DiemChuanRemoteDataSource
import com.example.doantotnghiep.screen.diemchuan.adapter.DiemChuanAdapter
import com.example.doantotnghiep.screen.nganh.fragment.NganhFragment
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_diem_chuan.*


class DiemChuanFragment : Fragment(), DiemChuanContract.View, OnItemRecyclerViewClickListener<DiemChuan> {
    private var diemchuanPresenter: DiemChuanContract.Presenter? = null

    private val adapter: DiemChuanAdapter by lazy { DiemChuanAdapter() }
    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diem_chuan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initData()
        diemchuanPresenter?.getDiemChuan()

    }

    private fun initView() {
        progressDialog = ProgressDialog(context)
        recyclerViewDiemChuan.setHasFixedSize(true)
//        recyclerViewDiemChuan.addItemDecoration(
//            DividerItemDecoration(
//                recyclerViewDiemChuan.context,
//                DividerItemDecoration.HORIZONTAL
//            )
//        )

        recyclerViewDiemChuan.adapter = adapter
        recyclerViewDiemChuan.layoutManager = LinearLayoutManager(context)
        adapter.registerItemRecyclerViewClickListener(this)

    }

    private fun initData() {
        progressDialog?.show()
        diemchuanPresenter = context?.let {
            DiemChuanPresenter(
                DiemChuanRepository.getInstance(DiemChuanRemoteDataSource.getInstance()),
                this
            )
        }

    }

    override fun onSuccess(data: MutableList<DiemChuan>) {
        progressDialog?.dismiss()
        adapter.updateData(data)

    }


    override fun onError(error: String) {
        progressDialog?.dismiss()

    }


    override fun onItemClickListener(item: DiemChuan?) {
        val nganh = item?.nganh
        openFragment(NganhFragment(),1 ,data = nganh)
    }
    private fun openFragment(fragment: Fragment, idSwitch: Int,data: Nganh?) {

        val bundle = Bundle()
        bundle.putSerializable("nganh", data)
        bundle.putInt("key", idSwitch)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }

}