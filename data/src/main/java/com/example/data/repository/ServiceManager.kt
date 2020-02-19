package com.example.data.repository

import android.util.Log
import com.example.common.TAG
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceManager {
    private val okHttpClient = HttpLoggingInterceptor().run {
        Log.d(TAG, "okHttpClient = HttpLoggingInterceptor")
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    val service: Services = Retrofit.Builder()
        //val service: TeamService = Retrofit.Builder()

        .baseUrl("https://formacion.free.beeceptor.com/my/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().run {
            //create<TeamService>(TeamService::class.java)
            create<Services>(Services::class.java)
        }/*
    val loginService: LoginService = Retrofit.Builder()
        .baseUrl("https://formacion.free.beeceptor.com/my/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().run {
            create<LoginService>(LoginService::class.java)
        }*/
}