package com.example.doantotnghiep.screen.login.fragment.childlogin

import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.data.source.user.UserRepository
import com.example.doantotnghiep.untils.Constant.isValidEmail
import com.example.doantotnghiep.untils.Constant.isValidPassword


class LoginPresenter(
    private val userRepository: UserRepository,
    private val view: LoginContract.View
) : LoginContract.Presenter {

    override fun login(email: String, password: String) {
        if (email.isValidEmail() && password.isValidPassword()) {
            userRepository.login(email, password, object : OnFetchDataJsonListener<User> {
                override fun onSuccess(data: User) {
                    view.onLoginSuccess(data)
                }
                override fun onError(error: String) {
                    view.onError(error)
                }
            })
        } else {
            view.onErrorValidate()
        }
    }

}
