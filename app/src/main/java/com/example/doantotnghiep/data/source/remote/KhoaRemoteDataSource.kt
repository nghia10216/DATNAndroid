package com.example.doantotnghiep.data.source.remote

import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.khoa.KhoaDataSource
import com.example.doantotnghiep.data.source.remote.retrofit2.GetDataFromUrl
import com.example.doantotnghiep.data.source.thongtinnganh.ThongTinNganhDataSource

class KhoaRemoteDataSource: KhoaDataSource.Remote {
    override fun getKhoa(listener: OnFetchDataJsonListener<MutableList<Khoa>>) {
        GetDataFromUrl(listener).getKhoa()
    }

    companion object {
        private var instance: KhoaRemoteDataSource ?= null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: KhoaRemoteDataSource().also { instance = it }
        }
    }
}
