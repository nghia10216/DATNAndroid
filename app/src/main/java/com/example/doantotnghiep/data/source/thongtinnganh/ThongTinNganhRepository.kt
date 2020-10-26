package com.example.doantotnghiep.data.source.thongtinnganh

import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.data.source.remote.ThongTinNganhRemoteDataSource


class ThongTinNganhRepository private constructor(private val remote: ThongTinNganhDataSource.Remote) :
    ThongTinNganhDataSource.Remote {

    companion object {
        private var instance: ThongTinNganhRepository? = null

        fun getInstance(
            remote: ThongTinNganhRemoteDataSource
        ) = instance ?: synchronized(this) {
            instance ?: ThongTinNganhRepository(remote = remote).also { instance = it }
        }
    }

    override fun getThongTinNganh(listener: OnFetchDataJsonListener<MutableList<ThongTinNganh>>) {
        remote.getThongTinNganh(listener)
    }
}

