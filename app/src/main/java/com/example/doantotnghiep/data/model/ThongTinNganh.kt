package com.example.doantotnghiep.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ThongTinNganh : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("TrinhDoDaoTao")
    @Expose
    var trinhDoDaoTao: String? = null

    @SerializedName("HinhThucDaoTao")
    @Expose
    var hinhThucDaoTao: String? = null

    @SerializedName("ThoiGianDaoTao")
    @Expose
    var thoiGianDaoTao: String? = null

    @SerializedName("ThoiGianTuyenSinhNopHoSo")
    @Expose
    var thoiGianTuyenSinhNopHoSo: String? = null

    @SerializedName("ThoiGianXetTuyenVaNhapHoc")
    @Expose
    var thoiGianXetTuyenVaNhapHoc: String? = null

    @SerializedName("HinhThucTuyenSinh")
    @Expose
    var hinhThucTuyenSinh: String? = null

    @SerializedName("ToHopMonXetTuyen")
    @Expose
    var toHopMonXetTuyen: String? = null

    @SerializedName("DiemChuanCacNam")
    @Expose
    var diemChuanCacNam: String? = null

    @SerializedName("ChiTieu")
    @Expose
    var chiTieu: String? = null

    @SerializedName("HocPhi")
    @Expose
    var hocPhi: String? = null

    @SerializedName("AnhGioiThieu")
    @Expose
    var anhGioiThieu: String? = null

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
//class ThongTinNganh {
//    @SerializedName("id")
//    @Expose
//    var id: Int? = null
//
//    @SerializedName("TrinhDoDaoTao")
//    @Expose
//    var trinhDoDaoTao: String? = null
//
//    @SerializedName("HinhThucDaoTao")
//    @Expose
//    var hinhThucDaoTao: String? = null
//
//    @SerializedName("ThoiGianDaoTao")
//    @Expose
//    var thoiGianDaoTao: String? = null
//
//    @SerializedName("ThoiGianTuyenSinhNopHoSo")
//    @Expose
//    var thoiGianTuyenSinhNopHoSo: String? = null
//
//    @SerializedName("ThoiGianXetTuyenVaNhapHoc")
//    @Expose
//    var thoiGianXetTuyenVaNhapHoc: String? = null
//
//    @SerializedName("HinhThucTuyenSinh")
//    @Expose
//    var hinhThucTuyenSinh: String? = null
//
//    @SerializedName("ToHopMonXetTuyen")
//    @Expose
//    var toHopMonXetTuyen: String? = null
//
//    @SerializedName("DiemChuanCacNam")
//    @Expose
//    var diemChuanCacNam: String? = null
//
//    @SerializedName("ChiTieu")
//    @Expose
//    var chiTieu: String? = null
//
//    @SerializedName("HocPhi")
//    @Expose
//    var hocPhi: String? = null
//
//    @SerializedName("AnhGioiThieu")
//    @Expose
//    var anhGioiThieu: String? = null
//
//    @SerializedName("idNganh")
//    @Expose
//    var idNganh: Int? = null
//
//    @SerializedName("created_at")
//    @Expose
//    var createdAt: Any? = null
//
//    @SerializedName("updated_at")
//    @Expose
//    var updatedAt: Any? = null
//}