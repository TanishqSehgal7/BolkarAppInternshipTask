package com.example.bolkarappinternshiptask.retrofit

import com.example.bolkarappinternshiptask.modelClass.*
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("/live/room.json")
    suspend fun getData() : Response<AllData>
}