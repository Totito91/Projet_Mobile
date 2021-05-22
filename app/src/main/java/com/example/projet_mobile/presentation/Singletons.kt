package com.example.projet_mobile.presentation

import com.example.projet_mobile.presentation.api.AOEApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons{
    companion object{
             val aoeApi: AOEApi = Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(AOEApi::class.java)
    }
}
