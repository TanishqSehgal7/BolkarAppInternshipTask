package com.example.bolkarappinternshiptask.viewmodel

import androidx.lifecycle.*
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository
import kotlinx.coroutines.*

class BolkarClubViewModel(private val bolkarClubRepository: BolkarClubRepository) : ViewModel() {

    private var job: Job

    init {
        job=CoroutineScope(Dispatchers.IO).launch (Dispatchers.IO) {
            bolkarClubRepository.loadData()
        }
    }
   val data : LiveData<AllData>
       get() = bolkarClubRepository.data

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}