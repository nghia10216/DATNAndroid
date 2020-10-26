package com.example.doantotnghiep.data.source.hoidap

import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

interface HoiDapDataSource {
    interface Remote {
        fun getHoiDap(
            email: String, password: String, idUser: Int,
            listener: OnFetchDataJsonListener<MutableList<HoiDap>>
        )

        fun postCauHoi(
            email: String, password: String, cauhoi: String, idUser: Int,
            listener: OnFetchDataJsonListener<HoiDap>
        )

        fun xoaCauHoi(email: String, password: String, idCauHoi: Int,
                      listener: OnFetchDataJsonListener<String>)
    }
}
