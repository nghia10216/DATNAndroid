package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Khoa : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("TenKhoa")
    @Expose
    var tenKhoa: String? = null

    @SerializedName("LogoKhoa")
    @Expose
    var logoKhoa: String? = null

    @SerializedName("SDT")
    @Expose
    var sDT: String? = null

    @SerializedName("Email")
    @Expose
    var email: String? = null

    @SerializedName("GioiThieuKhoa")
    @Expose
    var gioiThieuKhoa: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("hinhanhkhoa")
    @Expose
    var hinhanhkhoa: List<HinhAnhKhoa>? = null

    @SerializedName("donvihoptac")
    @Expose
    var donvihoptac: List<DonViHopTac>? = null

    @SerializedName("nganh")
    @Expose
    var nganh: List<Nganh>? = null

    @SerializedName("bomon")
    @Expose
    var bomon: List<BoMon>? = null
}