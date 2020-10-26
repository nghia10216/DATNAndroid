package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Nganh : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("MaNganh")
    @Expose
    var maNganh: String? = null

    @SerializedName("TenNganh")
    @Expose
    var tenNganh: String? = null

    @SerializedName("BangTotNghiep")
    @Expose
    var bangTotNghiep: String? = null

    @SerializedName("CongViecVaNoiLamViec")
    @Expose
    var congViecVaNoiLamViec: String? = null

    @SerializedName("GioiThieuNganh")
    @Expose
    var gioiThieuNganh: String? = null

    @SerializedName("KhungChuongTrinhDaoTao")
    @Expose
    var khungChuongTrinhDaoTao: String? = null

    @SerializedName("idKhoa")
    @Expose
    var idKhoa: Int? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("hinhanhnganh")
    @Expose
    var hinhanhnganh: List<HinhAnhNganh>? = null
}
