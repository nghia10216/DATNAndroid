package com.example.doantotnghiep.data.model

import android.annotation.SuppressLint
import android.os.Parcel

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion


@SuppressLint("ParcelCreator")
class Suggestion(suggestion: String, idNe: Int) : SearchSuggestion {
    var mName = suggestion.toLowerCase()
    var id = idNe
    var isHistory = false

    override fun getBody(): String {
        return mName
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {}

}