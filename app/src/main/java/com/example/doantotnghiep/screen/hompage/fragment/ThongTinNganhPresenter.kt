package com.example.doantotnghiep.screen.hompage.fragment


import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.data.source.thongtinnganh.ThongTinNganhRepository

class ThongTinNganhPresenter(
    private val thongTinNganhRepository: ThongTinNganhRepository,
    private val view: ThongTinNganhContract.View
) : ThongTinNganhContract.Presenter {
    override fun getThongTinNganh() {

        thongTinNganhRepository.getThongTinNganh(object :
            OnFetchDataJsonListener<MutableList<ThongTinNganh>> {

            override fun onError(error: String) {
                view.onError(error)
            }

            override fun onSuccess(data: MutableList<ThongTinNganh>) {
                view.onSuccess(data)
            }
        })
    }
}
