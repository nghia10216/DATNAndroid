package com.example.doantotnghiep.data.source.thongtinnganh

import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

interface ThongTinNganhDataSource {
    interface Remote {
        fun getThongTinNganh(
             listener: OnFetchDataJsonListener<MutableList<ThongTinNganh>>
        )
    }
}