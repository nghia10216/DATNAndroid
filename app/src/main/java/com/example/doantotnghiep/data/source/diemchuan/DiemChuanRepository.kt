package com.example.doantotnghiep.data.source.diemchuan

import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.data.source.khoa.KhoaDataSource
import com.example.doantotnghiep.data.source.remote.DiemChuanRemoteDataSource
import com.example.doantotnghiep.data.source.remote.KhoaRemoteDataSource
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener


class DiemChuanRepository private constructor(private val remote: DiemChuanDataSource.Remote) :
    DiemChuanDataSource.Remote{

    companion object {
        private var instance: DiemChuanRepository? = null

        fun getInstance(
            remote: DiemChuanRemoteDataSource
        ) = instance ?: synchronized(this) {
            instance ?: DiemChuanRepository(remote = remote).also { instance = it }
        }
    }

    override fun getDiemChuan(listener: OnFetchDataJsonListener<MutableList<DiemChuan>>) {
        remote.getDiemChuan(listener)
    }
}
