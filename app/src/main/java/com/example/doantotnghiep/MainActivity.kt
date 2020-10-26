package com.example.doantotnghiep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.doantotnghiep.screen.login.LoginParentFragment



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setTheme(R.style.ThemeLogin)
        setContentView(R.layout.activity_main)
        addFragment(LoginParentFragment())
    }


    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
}