package com.example.doantotnghiep.screen.login.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.doantotnghiep.R

import com.example.doantotnghiep.screen.login.fragment.childlogin.LoginFragment
import com.example.doantotnghiep.screen.login.fragment.childregister.RegisterFragment

class LoginViewpagerAdapter(fm: FragmentManager, context: Context) : FragmentStatePagerAdapter(fm) {

    private val listTab = arrayOf(
        context.resources.getString(R.string.login),
        context.resources.getString(R.string.register)
    )

    private val listFragment = arrayOf(LoginFragment(), RegisterFragment())

    override fun getItem(position: Int) = when (position) {
        POSITION_LOGIN -> {
            listFragment[POSITION_LOGIN]
        }
        POSITION_REGISTER -> {
            listFragment[POSITION_REGISTER]
        }
        else -> {
            listFragment[POSITION_LOGIN]
        }
    }

    override fun getCount() = listTab.size

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            POSITION_LOGIN -> return listTab[POSITION_LOGIN]
            POSITION_REGISTER -> return listTab[POSITION_REGISTER]
        }
        return super.getPageTitle(position)
    }

    companion object {
        const val POSITION_LOGIN = 0
        const val POSITION_REGISTER = 1
    }
}
