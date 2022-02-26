package com.example.bolkarappinternshiptask.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    val baseUrlForServer="https://api.bolkarapp.com/"
    val baseUrlForProfilePic="https://cdn1.bolkarapp.com/uploads/dp/"

    val instanceOfRetrofitWithApi: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrlForServer)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}