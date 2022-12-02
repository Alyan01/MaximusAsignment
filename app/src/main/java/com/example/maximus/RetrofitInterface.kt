package com.example.maximus

import retrofit2.http.GET
import com.example.maximus.ResponseModel
import retrofit2.Call

interface RetrofitInterface {
    @get:GET("fact")
    val data: Call<ResponseModel?>?
}