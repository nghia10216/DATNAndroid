package com.example.doantotnghiep.screen.login.fragment.childregister

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.UserRemoteDataSource
import com.example.doantotnghiep.data.source.user.UserRepository

import kotlinx.android.synthetic.main.fragment_register_child.*
import kotlinx.android.synthetic.main.fragment_register_child.errorTextView
import kotlinx.android.synthetic.main.fragment_register_child.passwordTextInput
import kotlinx.android.synthetic.main.fragment_register_child.usernameTextInput


class RegisterFragment : Fragment(), RegisterContract.View {

    private var registerPresenter: RegisterContract.Presenter? = null
    private var progressDialog: ProgressDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        registerButton.setOnClickListener {
            usernameTextInput.editText?.clearFocus()
            passwordTextInput.editText?.clearFocus()
            confirmPasswordTextInput.editText?.clearFocus()
            progressDialog?.show()
            val username = usernameTextInput.editText?.text.toString()
            val password = passwordTextInput.editText?.text.toString()
            val confirmPassword = confirmPasswordTextInput.editText?.text.toString()
            registerPresenter?.register(username, password, confirmPassword)
        }
        usernameTextInput.editText?.setOnFocusChangeListener { v, hasFocus ->
            errorTextView.text = ""
        }
        passwordTextInput.editText?.setOnFocusChangeListener { v, hasFocus ->
            errorTextView.text = ""
        }
        confirmPasswordTextInput.editText?.setOnFocusChangeListener { v, hasFocus ->
            errorTextView.text = ""
        }
    }

    private fun initData() {
        progressDialog = ProgressDialog(context)
        registerPresenter =
            RegisterPresenter(UserRepository.getInstance(UserRemoteDataSource.getInstance()), this)
    }

    override fun onRegisterSuccess(data: User) {
        progressDialog?.dismiss()
        Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
    }

    override fun onError(error: String) {
        progressDialog?.dismiss()

        context.let { Toast.makeText(it, error, Toast.LENGTH_SHORT).show() }

    }

    override fun onErrorValidate() {
        progressDialog?.dismiss()
        errorTextView.text = getString(R.string.error_syntax)
    }
}
