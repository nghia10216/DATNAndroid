package com.example.doantotnghiep.screen.diemchuan.fragment

import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.source.diemchuan.DiemChuanRepository
import com.example.doantotnghiep.data.source.khoa.KhoaRepository
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.screen.khoa.fragment.KhoaContract


class DiemChuanPresenter(
    private val diemchuanRepository: DiemChuanRepository,
    private val view: DiemChuanContract.View
) : DiemChuanContract.Presenter {
    override fun getDiemChuan() {
        diemchuanRepository.getDiemChuan(object :
            OnFetchDataJsonListener<MutableList<DiemChuan>> {

            override fun onError(error: String) {
                view.onError(error)
            }

            override fun onSuccess(data: MutableList<DiemChuan>) {
                view.onSuccess(data)
            }
        })
    }
}