package com.example.doantotnghiep.screen.contact.fragment

import com.example.doantotnghiep.data.model.HoiDap

interface HoiDapContract {
    interface Presenter {
        fun getHoiDap(email: String, password: String, idUser: Int)
        fun xoaCauHoi(email: String, password: String, idCauHoi: Int)
    }


    interface View {
        fun xoaCauHoiSucces()
        fun onGetHoiDapSuccess(data: MutableList<HoiDap>)
        fun onError(error: String)
    }

}