package com.example.bolkarappinternshiptask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance
import retrofit2.Response
import java.nio.file.Path

class BolkarClubRepository(val apiInterface: ApiInterface) {

    private val dataLiveData = MutableLiveData<AllData>()
    val data: LiveData<AllData>
        get() = dataLiveData

    private val profilePicUrlLiveData = MutableLiveData<String>()
    val profilePicurl : LiveData<String>
        get() = profilePicUrlLiveData

    suspend fun loadData() {
        val dataResult = apiInterface.getData()
        if (dataResult.body() !=null) {
            dataLiveData.postValue(dataResult.body())
            Log.d("ErrorResult1", dataResult.toString() + "\n\n" + dataResult.body())
        }
    }

    suspend fun loadProfileUrls(userId: String) {
        val profilePicUrlResult = apiInterface.getProfileUrl(userId)
        if (profilePicUrlResult.body()!=null) {
            profilePicUrlLiveData.postValue(profilePicUrlResult.body())
            Log.d("ErrorResult2", profilePicUrlResult.toString() + "\n\n" + profilePicUrlResult.body())
        }
    }
}