package com.example.doantotnghiep.screen.hompage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doantotnghiep.R
import com.example.doantotnghiep.screen.login.LoginParentFragment
import kotlinx.android.synthetic.main.fragment_not_login.*


class NotLoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dangnhapTextView.setOnClickListener {
            addFragment(LoginParentFragment())
        }
    }
    private fun addFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
}