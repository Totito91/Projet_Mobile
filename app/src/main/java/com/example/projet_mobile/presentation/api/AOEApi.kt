package com.example.projet_mobile.presentation.api

import retrofit2.Call
import retrofit2.http.GET




interface AOEApi {
    @GET("civilizations")
    fun getAOElist(): Call<AOEResponse>
}