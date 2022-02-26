package com.example.bolkarappinternshiptask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.retrofit.ApiInterface

class BolkarClubRepository(val apiInterface: ApiInterface) {

    private val dataLiveData = MutableLiveData<AllData>()
    val data: LiveData<AllData>
        get() = dataLiveData

    suspend fun loadData() {
        val dataResult = apiInterface.getData()
        if (dataResult.body() !=null) {
            dataLiveData.postValue(dataResult.body())
            Log.d("ErrorResult1", dataResult.toString() + "\n\n" + dataResult.body())
        }
    }
}