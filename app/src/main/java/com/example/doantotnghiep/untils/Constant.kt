package com.example.doantotnghiep.untils

import com.example.doantotnghiep.data.source.remote.retrofit2.DataClient
import com.example.doantotnghiep.data.source.remote.retrofit2.RetrofitClient
import java.util.regex.Pattern

object Constant {
    const val IP = "http://192.168.1.4/"
    const val BASE_URL = IP + "DoAnTotNghiep/public/api/"
    const val BASE_URL_IMAGE = IP +  "DoAnTotNghiep/public/upload/anhgioithieu/"
    const val BASE_URL_IMAGEKHOA =IP + "DoAnTotNghiep/public/upload/hinhanhkhoa/"
    const val BASE_URL_IMAGENGANH =IP + "DoAnTotNghiep/public/upload/hinhanhnganh/"
    const val BASE_URL_IMAGE_LOGO_KHOA = IP + "DoAnTotNghiep/public/upload/logokhoa/"
    const val BASE_URL_IMAGE_DONVI = IP + "DoAnTotNghiep/public/upload/donvihoptac/"
    const val BASE_URL_KHUNGDAOTAO = IP + "DoAnTotNghiep/public/upload/khungchuongtrinhdaotao/"
    fun getData(): DataClient? {
        return RetrofitClient.getClient(BASE_URL)?.create(DataClient::class.java)
    }

    private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
//    "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}$"
    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^(?=.*[0-9])(?=.*)(?=\\S+$).{8,}$"

    )

    fun String.isValidEmail(pattern: Pattern = EMAIL_ADDRESS_PATTERN): Boolean =
        pattern.matcher(this).matches()

    fun String.isValidPassword(pattern: Pattern = PASSWORD_PATTERN): Boolean =
        pattern.matcher(this).matches()
}
