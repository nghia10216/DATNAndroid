package com.example.doantotnghiep.data.source.user

import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener

interface UserDataSource {

    interface Remote {
        fun login(
            email: String,
            password: String, listener: OnFetchDataJsonListener<User>
        )

        fun register(
            email: String,
            password: String, listener: OnFetchDataJsonListener<User>
        )
    }
}