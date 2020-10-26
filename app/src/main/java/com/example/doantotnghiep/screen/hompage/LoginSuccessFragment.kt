package com.example.doantotnghiep.screen.hompage

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.data.model.User
import com.example.doantotnghiep.screen.contact.fragment.ContactFragment
import com.example.doantotnghiep.screen.hompage.fragment.ThongTinNganhFragment
import com.example.doantotnghiep.screen.khoa.fragment.KhoaFragment
import com.example.doantotnghiep.screen.nganh.fragment.NganhFragment
import kotlinx.android.synthetic.main.fragment_cong_viec_va_noi_lam_viec.*
import kotlinx.android.synthetic.main.fragment_login_success.*


class LoginSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //openFragment(ThongTinNganhFragment())
        initNavigation()
        openFragment(ThongTinNganhFragment())
    }

    private fun openFragment(fragment: Fragment) {


        if (fragment is ContactFragment) {
            val bundle = this.arguments
            if (bundle != null) {
                val email = bundle.getString("email")
                val password = bundle.getString("password")
                val idUser = bundle.getInt("idUser")

                val bundle1 = Bundle()
                bundle1.putInt("idUser", idUser)
                bundle1.putString("email", email)
                bundle1.putString("password", password)
                fragment.arguments = bundle1
            }
        }

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
//    private fun openFragment(fragment: Fragment) {
//        childFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .addToBackStack(null)
//            .commit()
//    }

    private fun initNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> {
                    selectedFragment = ThongTinNganhFragment()
                }
                R.id.nav_khoa -> {
                    selectedFragment = KhoaFragment()
                }
                R.id.nav_favorites -> {
                    selectedFragment = ContactFragment()
                }
            }

            selectedFragment?.let { openFragment(it) }
//            selectedFragment?.let {
//                childFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, it)
//                    .addToBackStack(null)
//                    .commit()
//            }
            true
        }
        var badge = bottom_navigation.getOrCreateBadge(R.id.nav_favorites)
        badge.isVisible = true
// An icon only badge will be displayed unless a number is set:
        badge.number = 99
    }


}