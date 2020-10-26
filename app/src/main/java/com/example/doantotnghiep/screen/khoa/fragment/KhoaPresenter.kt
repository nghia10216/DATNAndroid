package com.example.doantotnghiep.screen.khoa.fragment

import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.source.khoa.KhoaRepository
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener


class KhoaPresenter(
    private val khoaRepository: KhoaRepository,
    private val view: KhoaContract.View
) : KhoaContract.Presenter {
    override fun getThongTinKhoa() {
        khoaRepository.getKhoa(object :
            OnFetchDataJsonListener<MutableList<Khoa>> {

            override fun onError(error: String) {
                view.onError(error)
            }

            override fun onSuccess(data: MutableList<Khoa>) {
                view.onSuccess(data)
            }
        })
    }
}