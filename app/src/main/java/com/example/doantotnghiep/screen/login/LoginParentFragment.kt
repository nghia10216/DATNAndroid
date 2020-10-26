package com.example.doantotnghiep.screen.login

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.screen.login.adapter.LoginViewpagerAdapter
import kotlinx.android.synthetic.main.fragment_login_parent.*


class LoginParentFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_parent, container, false)
    }

    private fun initViewPagerAdapter() {
//        loginViewpager.adapter = context?.let { LoginViewpagerAdapter(childFragmentManager, it) }
        loginViewpager.adapter =
            context?.let { activity?.supportFragmentManager?.let { it1 -> LoginViewpagerAdapter(it1, it) } }
        loginTabLayout.setupWithViewPager(loginViewpager)
    }
}
