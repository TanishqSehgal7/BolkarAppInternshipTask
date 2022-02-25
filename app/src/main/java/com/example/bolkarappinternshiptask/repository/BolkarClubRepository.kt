package com.example.bolkarappinternshiptask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance
import java.nio.file.Path

class BolkarClubRepository(val apiInterface: ApiInterface) {

    // live data
//    private val hostLiveData = MutableLiveData<Host>()
//    val host: LiveData<Host>
//    get() = hostLiveData

    private val dataLiveData = MutableLiveData<AllData>()
    val data: LiveData<AllData>
        get() = dataLiveData

    private val profilePicUrlLiveData = MutableLiveData<String>()
    val profilePicurl : LiveData<String>
        get() = profilePicUrlLiveData

//    private val moderatorLiveData = MutableLiveData<List<Moderator>>()
//    val moderator: MutableLiveData<List<Moderator>>
//    get() = moderatorLiveData

//    private val speakerLiveData = MutableLiveData<List<Speaker>>()
//    val speaker: MutableLiveData<List<Speaker>>
//    get() = speakerLiveData

//    private val memberLiveData = MutableLiveData<List<Member>>()
//    val member: MutableLiveData<List<Member>>
//    get() = memberLiveData

//    private val dpLiveData = MutableLiveData<Int>()
//    val dp:LiveData<Int>
//    get() = dpLiveData

    suspend fun loadData() {
        val dataResult = apiInterface.getData()
        if (dataResult.body() !=null) {
            dataLiveData.postValue(dataResult.body())
            Log.d("ErrorResult", dataResult.toString() + "\n\n" + dataResult.body())
        }
    }

    suspend fun loadProfileUrls(userId: String) {
        val profilePicUrlResult = apiInterface.getProfileUrl(userId)
        if (profilePicUrlResult.body()!=null) {
            profilePicUrlLiveData.postValue(profilePicUrlResult.body())
        }
    }

//    suspend fun loadSpeakerData() {
//        val speakerResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfSpeakers()
//        if (speakerResult.body() !=null) {
//            speakerLiveData.postValue(speakerResult.body())
//        }
//    }

//    suspend fun loadModeratorData() {
//        val moderatorResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfModerators()
//        if (moderatorResult.body() !=null) {
//            moderatorLiveData.postValue(moderatorResult.body())
//        }
//    }

//    suspend fun loadMemberData() {
//        val memberResult = RetroFitInstance.instanceOfRetrofitWithApi.getDetailsOfMembers()
//        if (memberResult.body()!=null) {
//            memberLiveData.postValue(memberResult.body())
//        }
//    }
}