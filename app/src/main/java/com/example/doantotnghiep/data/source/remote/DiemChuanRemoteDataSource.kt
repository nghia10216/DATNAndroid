package com.example.doantotnghiep.data.source.remote

import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.source.diemchuan.DiemChuanDataSource
import com.example.doantotnghiep.data.source.remote.retrofit2.GetDataFromUrl


class DiemChuanRemoteDataSource: DiemChuanDataSource.Remote {
    override fun getDiemChuan(listener: OnFetchDataJsonListener<MutableList<DiemChuan>>) {
        GetDataFromUrl(listener).getDiemChuan()
    }

    companion object {
        private var instance: DiemChuanRemoteDataSource ?= null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: DiemChuanRemoteDataSource().also { instance = it }
        }
    }
}