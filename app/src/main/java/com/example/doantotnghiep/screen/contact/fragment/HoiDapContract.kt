package com.example.doantotnghiep.screen.contact.fragment

import com.example.doantotnghiep.data.model.HoiDap

interface HoiDapContract {
    interface Presenter {
        fun getHoiDap(email: String, password: String, idUser: Int)
    }

    interface View {
        fun onGetHoiDapSuccess(data: MutableList<HoiDap>)
        fun onError(error: String)
    }

}