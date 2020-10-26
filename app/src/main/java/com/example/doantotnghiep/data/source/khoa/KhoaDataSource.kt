package com.example.doantotnghiep.data.source.khoa

import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

interface KhoaDataSource {
    interface Remote {
        fun getKhoa(
            listener: OnFetchDataJsonListener<MutableList<Khoa>>
        )
    }
}