package com.example.doantotnghiep.screen.login.fragment.childlogin

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi

import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.data.source.remote.UserRemoteDataSource
import com.example.doantotnghiep.data.source.user.UserRepository
import com.example.doantotnghiep.screen.hompage.LoginSuccessFragment
import kotlinx.android.synthetic.main.fragment_login_child.*


class LoginFragment : Fragment(), LoginContract.View {

    var username = ""
    var password = ""
    private var loginPresenter: LoginContract.Presenter? = null
    private var progressDialog: ProgressDialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        loginButton.setOnClickListener {
            usernameTextInput.editText?.clearFocus()
            passwordTextInput.editText?.clearFocus()
            progressDialog?.show()
            username = usernameTextInput?.editText?.text.toString()
            password = passwordTextInput?.editText?.text.toString()
            loginPresenter?.login(username, password)
        }
        khongdangnhapTextView.setOnClickListener {

            val fragment = LoginSuccessFragment()
            val bundle = Bundle()
            bundle.putString("email", username)
            bundle.putString("password", password)
            fragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_layout, fragment)
                commit()
            }
        }

        usernameTextInput.editText?.setOnFocusChangeListener { v, hasFocus ->
            errorTextView!!.text = " "
        }
        passwordTextInput.editText?.setOnFocusChangeListener { v, hasFocus ->
            errorTextView!!.text = " "
        }
    }

    private fun initData() {
        progressDialog = ProgressDialog(context)
        loginPresenter = context?.let {
            LoginPresenter(
                UserRepository.getInstance(UserRemoteDataSource.getInstance()), this
            )
        }
    }

    override fun onErrorValidate() {
        progressDialog?.dismiss()
        errorTextView.text = getString(R.string.error_syntax)
    }

    override fun onLoginSuccess(data: User) {
        progressDialog?.dismiss()
        val fragment = LoginSuccessFragment()
        val bundle = Bundle()
        data.id?.let { bundle.putInt("idUser", it) }
        bundle.putString("email", username)
        bundle.putString("password", password)
        Log.d("DBLOGINFR", username +  password)
        fragment.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }

    override fun onError(error: String) {
        progressDialog?.dismiss()
        context.let { Toast.makeText(it, error, Toast.LENGTH_SHORT).show() }
    }


}