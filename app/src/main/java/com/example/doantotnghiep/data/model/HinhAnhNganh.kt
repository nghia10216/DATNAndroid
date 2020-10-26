package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class HinhAnhNganh: Serializable{
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("TenAnh")
    @Expose
    var tenAnh: String? = null

    @SerializedName("Link")
    @Expose
    var link: String? = null

    @SerializedName("idNganh")
    @Expose
    var idNganh: Int? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null
}
