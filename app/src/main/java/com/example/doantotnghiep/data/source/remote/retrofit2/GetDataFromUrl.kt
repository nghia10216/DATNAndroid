package com.example.doantotnghiep.data.source.remote.retrofit2

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.doantotnghiep.data.model.*
import com.example.doantotnghiep.data.source.remote.OnFetchDataJsonListener
import com.example.doantotnghiep.untils.Constant
import retrofit2.Call
import retrofit2.Response
import java.nio.charset.StandardCharsets
import java.util.*

@Suppress("UNCHECKED_CAST")
class GetDataFromUrl<T>(private val listener: OnFetchDataJsonListener<T>) {

    fun login(email: String, password: String) {
        val dataClient = Constant.getData()
        val callback = dataClient?.login(email, password)
        callback?.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 401) {
                    listener.onError("Sai tên tài khoản hoặc mật khẩu")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }

    fun register(email: String, password: String) {
        val dataClient = Constant.getData()
        val callback = dataClient?.register(email, password)
        callback?.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 400) {
                    listener.onError("Tài khoản đã tồn tại")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }


    fun getThongTinNganh() {
        val dataClient = Constant.getData()
        val callback = dataClient?.getThongTinNganh()
        callback?.enqueue(object : retrofit2.Callback<MutableList<ThongTinNganh>> {

            override fun onResponse(
                call: Call<MutableList<ThongTinNganh>>,
                response: Response<MutableList<ThongTinNganh>>
            ) {
                if (response.code() == 404) {
                    listener.onError("Không có thông tin ngành")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<MutableList<ThongTinNganh>>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }

    fun getKhoa() {
        val dataClient = Constant.getData()
        val callback = dataClient?.getKhoa()
        callback?.enqueue(object : retrofit2.Callback<MutableList<Khoa>> {

            override fun onResponse(
                call: Call<MutableList<Khoa>>,
                response: Response<MutableList<Khoa>>
            ) {
                if (response.code() == 404) {
                    listener.onError("Không có khoa")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<MutableList<Khoa>>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getHoiDap(email: String, password: String, idUser: Int) {
     //   val decodedBytes = Base64.getDecoder().decode(password)

        val base = "$email:$password"
        val authHeader: String = "Basic " + Base64.getEncoder().encodeToString(base.toByteArray())
        val dataClient = Constant.getData()
        val callback = dataClient?.getHoiDap(authHeader, idUser)
        callback?.enqueue(object : retrofit2.Callback<MutableList<HoiDap>> {
            override fun onResponse(
                call: Call<MutableList<HoiDap>>,
                response: Response<MutableList<HoiDap>>
            ) {
                if (response.code() == 404) {
                    listener.onError("Không có hỏi đáp")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<MutableList<HoiDap>>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun postCauHoi(email: String, password: String, cauhoi: String,idUser: Int) {
        //   val decodedBytes = Base64.getDecoder().decode(password)
        val base = "$email:$password"
        val authHeader: String = "Basic " + Base64.getEncoder().encodeToString(base.toByteArray())
        val dataClient = Constant.getData()
        val callback = dataClient?.postCauHoi(authHeader, cauhoi, "", idUser)
        callback?.enqueue(object : retrofit2.Callback<HoiDap> {
            override fun onResponse(call: Call<HoiDap>, response: Response<HoiDap>) {
                if (response.code() == 404) {
                    listener.onError("Không có câu hỏi")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<HoiDap>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }

        })
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun xoaCauHoi(email: String, password: String, idCauHoi: Int) {
        //   val decodedBytes = Base64.getDecoder().decode(password)
        val base = "$email:$password"
        val authHeader: String = "Basic " + Base64.getEncoder().encodeToString(base.toByteArray())
        val dataClient = Constant.getData()
        val callback = dataClient?.xoaCauHoi(authHeader,  idCauHoi)
        callback?.enqueue(object : retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.code() == 404) {
                    listener.onError("Không có câu hỏi")
                } else {
                    listener.onSuccess("Thành công" as T)
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }

        })
    }

    fun getDiemChuan() {
        val dataClient = Constant.getData()
        val callback = dataClient?.getDiemChuan()
        callback?.enqueue(object : retrofit2.Callback<MutableList<DiemChuan>> {

            override fun onResponse(
                call: Call<MutableList<DiemChuan>>,
                response: Response<MutableList<DiemChuan>>
            ) {
                if (response.code() == 404) {
                    listener.onError("Không có điểm chuẩn")
                } else {
                    listener.onSuccess(response.body() as T)
                }
            }

            override fun onFailure(call: Call<MutableList<DiemChuan>>, t: Throwable) {
                listener.onError("Lỗi kết nối")
            }
        })
    }
}