package com.example.doantotnghiep.screen.hompage.fragment

import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.model.User

interface ThongTinNganhContract {

    interface Presenter {
        fun getThongTinNganh()
    }

    interface View {

        fun onSuccess(data: MutableList<ThongTinNganh>)
        fun onError(error: String)
    }
}