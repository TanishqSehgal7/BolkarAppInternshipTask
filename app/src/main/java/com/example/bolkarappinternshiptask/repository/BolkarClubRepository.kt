package com.example.bolkarappinternshiptask.repository

import androidx.lifecycle.MutableLiveData
import com.example.bolkarappinternshiptask.modelClass.Host
import com.example.bolkarappinternshiptask.modelClass.Member
import com.example.bolkarappinternshiptask.modelClass.Moderator
import com.example.bolkarappinternshiptask.modelClass.Speaker
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance

class BolkarClubRepository {

    // live data
    private val hostLiveData = MutableLiveData<List<Host>>()
    val host: MutableLiveData<List<Host>>
    get() = hostLiveData

    private val moderatorLiveData = MutableLiveData<List<Moderator>>()
    val moderator: MutableLiveData<List<Moderator>>
    get() = moderatorLiveData

    private val speakerLiveData = MutableLiveData<List<Speaker>>()
    val speaker: MutableLiveData<List<Speaker>>
    get() = speakerLiveData

    private val memberLiveData = MutableLiveData<List<Member>>()
    val member: MutableLiveData<List<Member>>
    get() = memberLiveData

//    private val dpLiveData = MutableLiveData<Int>()
//    val dp:LiveData<Int>
//    get() = dpLiveData

    suspend fun loadHostData() {
        val hostResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfHosts()
        if (hostResult.body()!=null) {
            hostLiveData.postValue(hostResult.body())
        }
    }

    suspend fun loadSpeakerData() {
        val speakerResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfSpeakers()
        if (speakerResult.body() !=null) {
            speakerLiveData.postValue(speakerResult.body())
        }
    }

    suspend fun loadModeratorData() {
        val moderatorResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfModerators()
        if (moderatorResult.body() !=null) {
            moderatorLiveData.postValue(moderatorResult.body())
        }
    }

    suspend fun loadMemberData() {
        val memberResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfMembers()
        if (memberResult.body()!=null) {
            memberLiveData.postValue(memberResult.body())
        }
    }



}