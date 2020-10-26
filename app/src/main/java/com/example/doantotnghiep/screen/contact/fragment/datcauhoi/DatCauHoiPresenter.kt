package com.example.doantotnghiep.screen.contact.fragment.datcauhoi

import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.source.hoidap.HoiDapRepository
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener


class DatCauHoiPresenter(private val hoidapRepository: HoiDapRepository,
                      private val view: DatCauHoiContract.View
) : DatCauHoiContract.Presenter {

    override fun postCauHoi(email: String, password: String, cauhoi: String, idUser: Int) {
        hoidapRepository.postCauHoi(email, password, cauhoi,  idUser, object :
            OnFetchDataJsonListener<HoiDap> {
            override fun onError(error: String) {
                view.onError(error)
            }

            override fun onSuccess(data: HoiDap) {
                view.onSucces(data)
            }
        })
    }

}