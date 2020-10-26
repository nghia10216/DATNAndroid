package com.example.doantotnghiep.screen.contact.fragment

import com.example.doantotnghiep.data.model.HoiDap

import com.example.doantotnghiep.data.source.hoidap.HoiDapRepository
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

class HoiDapPresenter(
    private val hoidapRepository: HoiDapRepository,
    private val view: HoiDapContract.View
) : HoiDapContract.Presenter {
    override fun getHoiDap(email: String, password: String, idUser: Int) {
        hoidapRepository.getHoiDap(email, password, idUser, object :
            OnFetchDataJsonListener<MutableList<HoiDap>> {
            override fun onError(error: String) {
                view.onError(error)
            }

            override fun onSuccess(data: MutableList<HoiDap>) {
                view.onGetHoiDapSuccess(data)
            }
        })
    }

    override fun xoaCauHoi(email: String, password: String, idCauHoi: Int) {
        hoidapRepository.xoaCauHoi(email, password, idCauHoi, object :
            OnFetchDataJsonListener<String> {
            override fun onError(error: String) {
                view.onError(error)
            }
            override fun onSuccess(data: String) {
                view.xoaCauHoiSucces()
            }
        })
    }

}
