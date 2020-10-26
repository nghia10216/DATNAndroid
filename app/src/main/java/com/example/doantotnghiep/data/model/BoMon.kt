package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class BoMon: Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("TenBoMon")
    @Expose
    var tenBoMon: String? = null

    @SerializedName("GioiThieuBoMon")
    @Expose
    var gioiThieuBoMon: String? = null

    @SerializedName("idKhoa")
    @Expose
    var idKhoa: Int? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null
}