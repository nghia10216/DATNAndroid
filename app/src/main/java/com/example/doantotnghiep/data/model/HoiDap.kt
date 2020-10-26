package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class HoiDap : Serializable{
    @SerializedName("CauTraLoi")
    @Expose
    var cauTraLoi: String? = null

    @SerializedName("CauHoi")
    @Expose
    var cauHoi: String? = null

    @SerializedName("idUser")
    @Expose
    var idUser: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
}