package com.example.projet_mobile.presentation

import com.example.projet_mobile.presentation.AOEApplication.Companion.context
import com.example.projet_mobile.presentation.api.AOEApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons{
    companion object{
        var cache = Cache(File(context?.cacheDir,"response"), 10 * 1024 *1024)
        val okHttpClient : OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()
        val aoeApi: AOEApi = Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(AOEApi::class.java)
    }
}
