package com.example.maximus

import com.google.gson.annotations.SerializedName

class ResponseModel {
    @SerializedName("fact")
    var fact: String? = null

    @SerializedName("length")
    var length: Int? = null
}