package com.example.doantotnghiep.screen.login.fragment.childlogin

import com.example.doantotnghiep.data.model.User

interface LoginContract {

    interface Presenter {

        fun login(email: String, password: String)
//        fun onLoginResult(result: Int)
//        fun onConnectedFailed(exception: Exception?)
//        fun onLoginFailed()
    }

    interface View {

        fun onErrorValidate()
        fun onLoginSuccess(data: User)
        fun onError(error: String)
    }
}
