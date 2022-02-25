package com.example.bolkarappinternshiptask.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository

class ViewModelFactory(private val bolkarClubRepository: BolkarClubRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BolkarClubViewModel(bolkarClubRepository) as T
    }
}