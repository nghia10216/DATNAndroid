package com.example.doantotnghiep.data.source.remote.retrofit2

import com.example.doantotnghiep.data.model.*
import retrofit2.Call
import retrofit2.http.*


interface DataClient {
    //    @Multipart
//    @POST("uploadanh.php")
//    fun uploadPhoto(@Part photo: MultipartBody.Part): Call<String>
//
//    @FormUrlEncoded
//    @POST("insert.php")
//    fun insertData(@Field("taikhoan") taikhoan: String
//    , @Field("matkhau") matkhau: String
//    , @Field("hinhanh") hinhanh: String) :Call<String>
//
//    @FormUrlEncoded
//    @POST("login.php")
//    fun loginData(@Field("taikhoan") taikhoan: String
//    , @Field("matkhau") matkhau: String) : Call<List<SinhVien>>
//
//    @GET("delete.php")
//    fun deleteData(@Query("id") id: String, @Query("hinhanh") hinhanh: String): Call<String>
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String, @Field("password") password: String
    ): Call<User>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("email") email: String, @Field("password") password: String
    ): Call<User>

    @GET("hoidap/{hoidap}")
    fun getHoiDap(
        @Header("Authorization") authHeader: String,
        @Path("hoidap") idUser: Int
    ): Call<MutableList<HoiDap>>

    @FormUrlEncoded
    @POST("hoidap")
    fun postCauHoi(
        @Header("Authorization") authHeader: String,
        @Field("CauHoi") cauhoi: String,
        @Field("CauTraLoi") cautraloi: String,
        @Field("idUser") idUser: Int
    ): Call<HoiDap>

    @DELETE("hoidap/{hoidap}")
    fun xoaCauHoi(
        @Header("Authorization") authHeader: String,
        @Path("hoidap") idCauHoi: Int
    ): Call<String>


    @GET("user")
    fun getUser(@Header("Authorization") authHeader: String): Call<List<Khoa>>

    @GET("thongtinnganh")
    fun getThongTinNganh(): Call<MutableList<ThongTinNganh>>

    @GET("khoa")
    fun getKhoa(): Call<MutableList<Khoa>>

    @GET("diemchuan")
    fun getDiemChuan(): Call<MutableList<DiemChuan>>


}