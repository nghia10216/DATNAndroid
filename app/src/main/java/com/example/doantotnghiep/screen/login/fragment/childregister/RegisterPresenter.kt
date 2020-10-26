package com.example.doantotnghiep.screen.login.fragment.childregister


import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.data.source.user.UserRepository
import com.example.doantotnghiep.untils.Constant.isValidEmail
import com.example.doantotnghiep.untils.Constant.isValidPassword


class RegisterPresenter(
    private val userRepository: UserRepository,
    private val view: RegisterContract.View
) : RegisterContract.Presenter {

    override fun register(email: String, password: String, confirmPassword: String) {
        if (email.isValidEmail() && password.isValidPassword() && (password == confirmPassword)) {
            userRepository.register(email, password, object : OnFetchDataJsonListener<User> {
                override fun onSuccess(data: User) {
                    view.onRegisterSuccess(data)
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
