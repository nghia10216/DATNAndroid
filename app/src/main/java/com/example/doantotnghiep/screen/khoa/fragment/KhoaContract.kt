package com.example.doantotnghiep.screen.khoa.fragment

import com.example.doantotnghiep.data.model.Khoa


interface KhoaContract {
    interface Presenter {
        fun getThongTinKhoa()
    }

    interface View {

        fun onSuccess(data: MutableList<Khoa>)
        fun onError(error: String)
    }
}