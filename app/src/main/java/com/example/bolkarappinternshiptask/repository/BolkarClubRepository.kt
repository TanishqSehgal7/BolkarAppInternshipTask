package com.example.bolkarappinternshiptask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bolkarappinternshiptask.modelClass.Host
import com.example.bolkarappinternshiptask.modelClass.Member
import com.example.bolkarappinternshiptask.modelClass.Moderator
import com.example.bolkarappinternshiptask.modelClass.Speaker
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance

class BolkarClubRepository(val apiInterface: ApiInterface) {

    // live data
    private val hostLiveData = MutableLiveData<Host>()
    val host: LiveData<Host>
    get() = hostLiveData

//    private val moderatorLiveData = MutableLiveData<List<Moderator>>()
//    val moderator: MutableLiveData<List<Moderator>>
//    get() = moderatorLiveData
//
//    private val speakerLiveData = MutableLiveData<List<Speaker>>()
//    val speaker: MutableLiveData<List<Speaker>>
//    get() = speakerLiveData
//
//    private val memberLiveData = MutableLiveData<List<Member>>()
//    val member: MutableLiveData<List<Member>>
//    get() = memberLiveData

//    private val dpLiveData = MutableLiveData<Int>()
//    val dp:LiveData<Int>
//    get() = dpLiveData

    suspend fun loadHostData() {
        val hostResult = apiInterface.getDetailsOfHosts()
        if (hostResult.body() !=null) {
            hostLiveData.postValue(hostResult.body())
            Log.d("ErrorResult", hostResult.message().toString())
        }
    }

//    suspend fun loadSpeakerData() {
//        val speakerResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfSpeakers()
//        if (speakerResult.body() !=null) {
//            speakerLiveData.postValue(speakerResult.body())
//        }
//    }
//
//    suspend fun loadModeratorData() {
//        val moderatorResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfModerators()
//        if (moderatorResult.body() !=null) {
//            moderatorLiveData.postValue(moderatorResult.body())
//        }
//    }
//
//    suspend fun loadMemberData() {
//        val memberResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfMembers()
//        if (memberResult.body()!=null) {
//            memberLiveData.postValue(memberResult.body())
//        }
//    }



}