package com.example.doantotnghiep.data.source.remote

import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.remote.retrofit2.GetDataFromUrl
import com.example.doantotnghiep.data.source.thongtinnganh.ThongTinNganhDataSource

class ThongTinNganhRemoteDataSource: ThongTinNganhDataSource.Remote {
    override fun getThongTinNganh(listener: OnFetchDataJsonListener<MutableList<ThongTinNganh>>) {
        GetDataFromUrl(listener).getThongTinNganh()
    }

    companion object {
        private var instance: ThongTinNganhRemoteDataSource ?= null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: ThongTinNganhRemoteDataSource().also { instance = it }
        }
    }
}