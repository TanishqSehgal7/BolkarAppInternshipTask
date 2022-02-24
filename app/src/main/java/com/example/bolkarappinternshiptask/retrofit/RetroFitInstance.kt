package com.example.bolkarappinternshiptask.retrofit

import com.example.bolkarappinternshiptask.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    val baseUrlForServer="https://api.bolkarapp.com/"
//    val serverForJsonData= "https://api.bolkarapp.com/live/room.json"
//    val serverForProfileImages = "https://api.bolkarapp.com/uploads/dp/"

    val instanceOfRetrofitWithApi: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrlForServer)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}