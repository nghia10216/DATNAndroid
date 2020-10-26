package com.example.doantotnghiep.data.source.khoa

import com.example.doantotnghiep.data.model.Khoa

import com.example.doantotnghiep.data.source.remote.KhoaRemoteDataSource
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener


class KhoaRepository private constructor(private val remote: KhoaDataSource.Remote) :
    KhoaDataSource.Remote{

    companion object {
        private var instance: KhoaRepository? = null

        fun getInstance(
            remote: KhoaRemoteDataSource
        ) = instance ?: synchronized(this) {
            instance ?: KhoaRepository(remote = remote).also { instance = it }
        }
    }

    override fun getKhoa(listener: OnFetchDataJsonListener<MutableList<Khoa>>) {
        remote.getKhoa(listener)
    }

}
