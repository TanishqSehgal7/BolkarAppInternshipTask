package com.example.bolkarappinternshiptask.retrofit

import com.example.bolkarappinternshiptask.modelClass.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiInterface {

//    @GET("/live/room.json")
//    suspend fun getDetailsOfMembers() : Response<List<Member>>

    @GET("/live/room.json")
    suspend fun getData() : Response<AllData>

    @GET("/live/uploads/dp/{{u}}.jpg")
    suspend fun getProfileUrl(@Path("u") userId:String) : Response<String>


/*    @GET("/live/room.json")
    suspend fun getDetailsOfHosts() : Response<Host>

    @GET("/live/room.json")
    suspend fun getDetailsOfModerators() : Response<List<Moderator>>

    @GET("/live/room.json")
    suspend fun getDetailsOfSpeakers() : Response<List<Speaker>>*/

//    @GET("uploads/dp/{u}.jpg")
//    fun getDpForEveryOne(@Path("u.jpg") userId:String) : Response<Int>
}