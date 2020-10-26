package com.example.doantotnghiep.data.source.remote

import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.retrofit2.GetDataFromUrl
import com.example.doantotnghiep.data.source.user.UserDataSource

class UserRemoteDataSource() : UserDataSource.Remote{
    override fun login(email: String, password: String, listener: OnFetchDataJsonListener<User>) {
        GetDataFromUrl(listener).login(email, password)
    }

    override fun register(email: String, password: String, listener: OnFetchDataJsonListener<User>) {
        GetDataFromUrl(listener).register(email, password)
    }
    companion object {
        private var instance: UserRemoteDataSource ?= null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: UserRemoteDataSource().also { instance = it }
        }
    }
}