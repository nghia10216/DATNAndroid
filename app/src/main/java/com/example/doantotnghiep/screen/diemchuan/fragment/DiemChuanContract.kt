package com.example.doantotnghiep.screen.diemchuan.fragment

import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.model.Khoa

interface DiemChuanContract {

    interface Presenter {
        fun getDiemChuan()
    }

    interface View {

        fun onSuccess(data: MutableList<DiemChuan>)
        fun onError(error: String)
    }
}