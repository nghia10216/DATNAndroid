package com.example.doantotnghiep.data.source.diemchuan

import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

interface DiemChuanDataSource {
    interface Remote {
        fun getDiemChuan(
            listener: OnFetchDataJsonListener<MutableList<DiemChuan>>
        )
    }
}

