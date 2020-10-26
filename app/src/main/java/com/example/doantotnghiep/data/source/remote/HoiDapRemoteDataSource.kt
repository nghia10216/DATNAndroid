package com.example.doantotnghiep.data.source.remote

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.hoidap.HoiDapDataSource
import com.example.doantotnghiep.data.source.remote.retrofit2.GetDataFromUrl


class HoiDapRemoteDataSource : HoiDapDataSource.Remote {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getHoiDap(
        email: String,
        password: String,
        idUser: Int,
        listener: OnFetchDataJsonListener<MutableList<HoiDap>>
    ) {
        GetDataFromUrl(listener).getHoiDap(email, password, idUser)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun postCauHoi(
        email: String,
        password: String,
        cauhoi: String,
        idUser: Int,
        listener: OnFetchDataJsonListener<HoiDap>
    ) {
        GetDataFromUrl(listener).postCauHoi(email, password, cauhoi, idUser)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun xoaCauHoi(
        email: String,
        password: String,
        idCauHoi: Int,
        listener: OnFetchDataJsonListener<String>
    ) {
        GetDataFromUrl(listener).xoaCauHoi(email, password, idCauHoi)
    }

    companion object {
        private var instance: HoiDapRemoteDataSource? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: HoiDapRemoteDataSource().also { instance = it }
        }
    }
}
