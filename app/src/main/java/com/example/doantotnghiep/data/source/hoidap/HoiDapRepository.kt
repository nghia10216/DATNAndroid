package com.example.doantotnghiep.data.source.hoidap

import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.source.remote.HoiDapRemoteDataSource
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

class HoiDapRepository private constructor(private val remote: HoiDapDataSource.Remote) :
    HoiDapDataSource.Remote {

    companion object {
        private var instance: HoiDapRepository? = null

        fun getInstance(
            remote: HoiDapRemoteDataSource
        ) = instance ?: synchronized(this) {
            instance ?: HoiDapRepository(remote = remote).also { instance = it }
        }
    }

    override fun getHoiDap(
        email: String,
        password: String,
        idUser: Int,
        listener: OnFetchDataJsonListener<MutableList<HoiDap>>
    ) {
        remote.getHoiDap(email, password, idUser, listener)
    }

    override fun postCauHoi(
        email: String,
        password: String,
        cauhoi: String,
        idUser: Int,
        listener: OnFetchDataJsonListener<HoiDap>
    ) {
        remote.postCauHoi(email, password, cauhoi, idUser, listener)
    }

    override fun xoaCauHoi(
        email: String,
        password: String,
        idCauHoi: Int,
        listener: OnFetchDataJsonListener<String>
    ) {
        remote.xoaCauHoi(email, password, idCauHoi, listener)
    }
}
