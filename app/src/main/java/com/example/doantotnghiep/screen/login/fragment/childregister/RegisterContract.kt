package com.example.doantotnghiep.screen.login.fragment.childregister

import com.example.doantotnghiep.data.model.User
import java.lang.Exception


interface RegisterContract {

    interface Presenter {

        fun register(email: String, password: String, confirmPassword: String)
    }

    interface View {

        fun onRegisterSuccess(data: User)
        fun onError(error: String)
        fun onErrorValidate()
    }
}
