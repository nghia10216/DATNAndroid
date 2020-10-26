package com.example.doantotnghiep.screen.contact.fragment.datcauhoi

import com.example.doantotnghiep.data.model.HoiDap

interface DatCauHoiContract {
    interface Presenter {
        fun postCauHoi(email: String, password: String, cauhoi: String, idUser: Int)
    }
    interface View{
        fun onSucces(data: HoiDap)
        fun onError(error: String)

    }
}