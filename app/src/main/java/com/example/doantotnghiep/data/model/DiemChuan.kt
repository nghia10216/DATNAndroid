package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DiemChuan {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("ToHop")
    @Expose
    var toHop: String? = null

    @SerializedName("DiemTrungTuyen")
    @Expose
    var diemTrungTuyen: String? = null

    @SerializedName("DieuKienPhu")
    @Expose
    var dieuKienPhu: String? = null

    @SerializedName("idNganh")
    @Expose
    var idNganh: Int? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: Any? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: Any? = null

    @SerializedName("nganh")
    @Expose
    var nganh: Nganh? = null
}