package com.example.doantotnghiep.screen.khoa.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.doantotnghiep.R
import com.example.doantotnghiep.screen.khoa.fragment.GioiThieuKhoaFragment
import com.example.doantotnghiep.screen.khoa.fragment.NganhBomonFragment

class KhoaViewpagerAdapter(fm: FragmentManager, context: Context) : FragmentStatePagerAdapter(fm) {

    private val listTab = arrayOf(
        context.resources.getString(R.string.intro),
        context.resources.getString(R.string.nganhbomon),
    )

    private val listFragment =
        arrayOf(GioiThieuKhoaFragment(), NganhBomonFragment())

    override fun getItem(position: Int) = when (position) {
        POSITION_INTRO -> {
            listFragment[POSITION_INTRO]
        }
        POSITION_NGANH_BOMON -> {
            listFragment[POSITION_NGANH_BOMON]
        }
        else -> {
            listFragment[POSITION_INTRO]
        }
    }

    override fun getCount() = listTab.size

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            POSITION_INTRO -> return listTab[POSITION_INTRO]
            POSITION_NGANH_BOMON -> return listTab[POSITION_NGANH_BOMON]
        }
        return super.getPageTitle(position)
    }

    companion object {
        const val POSITION_INTRO = 0
        const val POSITION_NGANH_BOMON = 1
    }
}