package com.example.projet_mobile.presentation

import android.app.Application
import android.content.Context

class AOEApplication : Application() {
    companion object{
    var context: Context? = null
}
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}