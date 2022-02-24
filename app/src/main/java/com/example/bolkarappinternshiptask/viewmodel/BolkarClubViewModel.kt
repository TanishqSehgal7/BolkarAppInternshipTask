package com.example.bolkarappinternshiptask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bolkarappinternshiptask.modelClass.Host
import com.example.bolkarappinternshiptask.modelClass.Member
import com.example.bolkarappinternshiptask.modelClass.Moderator
import com.example.bolkarappinternshiptask.modelClass.Speaker
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import kotlinx.coroutines.*

class BolkarClubViewModel(application: Application) : AndroidViewModel(application) {

    private var job: Job

    private val bolkalClubRepository : BolkarClubRepository

    init {
        bolkalClubRepository=BolkarClubRepository()

        job=CoroutineScope(Dispatchers.IO).launch (Dispatchers.IO) {
            bolkalClubRepository.loadHostData()
            bolkalClubRepository.loadSpeakerData()
            bolkalClubRepository.loadMemberData()
            bolkalClubRepository.loadModeratorData()
        }
    }

    val host: MutableLiveData<List<Host>>
        get() = bolkalClubRepository.host

    val speaker: MutableLiveData<List<Speaker>>
        get() = bolkalClubRepository.speaker

    val moderator: MutableLiveData<List<Moderator>>
        get() = bolkalClubRepository.moderator

    val member: MutableLiveData<List<Member>>
        get() = bolkalClubRepository.member


//    val host: MutableLiveData<List<Host>>
//        get() {
//            job= viewModelScope.launch {
//                val hostResponse=bolkalClubRepository.loadHostData()
//                withContext(Dispatchers.Main) {
//                    if (hostResponse.isSuccessful) {
//                       host.postValue(hostResponse.body())
//                        Log.d("ViewModel", host.toString())
//                    } else {
//                        hostResponse.message()
//                    }
//                }
//            }
//            return host
//        }

//    val speaker: MutableLiveData<List<Speaker>>
//        get() {
//
//            job= viewModelScope.launch {
//                val speakerResponse=bolkalClubRepository.loadSpeakerData()
//                withContext(Dispatchers.Main) {
//                    if (speakerResponse.isSuccessful) {
//                        speaker.postValue(speakerResponse.body())
//                        Log.d("ViewModel", speaker.toString())
//                    } else {
//                        speakerResponse.message()
//                    }
//                }
//            }
//
//            return speaker
//        }

//    val moderator: MutableLiveData<List<Moderator>>
//        get() {
//            job= viewModelScope.launch {
//                val moderatorResponse=bolkalClubRepository.loadModeratorData()
//                withContext(Dispatchers.Main) {
//                    if (moderatorResponse.isSuccessful) {
//                        moderator.postValue(moderatorResponse.body())
//                        Log.d("ViewModel", moderator.toString())
//                    } else {
//                        moderatorResponse.message()
//                    }
//                }
//            }
//            return moderator
//        }

//    val member: MutableLiveData<List<Member>>
//        get() {
//            job= viewModelScope.launch {
//                val memberResponse=bolkalClubRepository.loadMemberData()
//                withContext(Dispatchers.Main) {
//                    if (memberResponse.isSuccessful) {
//                        member.postValue(memberResponse.body())
//                        Log.d("ViewModel", member.toString())
//                    } else {
//                        memberResponse.message()
//                    }
//                }
//            }
//            return member
//        }

    // cancel ongoing jobs on viewmodel once destroyed
//    override fun onCleared() {
//        super.onCleared()
//        job?.cancel()
//    }

}