package com.example.projet_mobile.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface AOEApi {
    @GET("civilizations")
    fun getAOElist(): Call<AOEListResponse>

    @GET("civilization/{id}")
    fun getAOEdetail(@Path("id") id: Int?): Call<AOEDetailResponse>
}