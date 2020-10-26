package com.example.doantotnghiep.data.source.user

import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.data.source.remote.UserRemoteDataSource

class UserRepository private constructor(private val remote: UserDataSource.Remote) :UserDataSource.Remote{

    override fun login(email: String, password: String, listener: OnFetchDataJsonListener<User>) {
        remote.login(email, password, listener)
    }

    override fun register(email: String, password: String, listener: OnFetchDataJsonListener<User>) {
        remote.register(email, password, listener)
    }
    companion object {
        private var instance: UserRepository? = null

        fun getInstance(
            remote: UserRemoteDataSource
        ) = instance ?: synchronized(this) {
            instance ?: UserRepository(remote = remote).also { instance = it }
        }
    }
}