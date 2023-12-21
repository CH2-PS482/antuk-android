package com.antukcapstone.antuk.ui.screens.account.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: AntukRepository): ViewModel() {
    fun getLoggedInUser() : LiveData<UserModel> {
        return repository.getLoggedInUser().asLiveData()
    }

    fun signOut() {
        viewModelScope.launch {
            repository.signOut()
        }
    }
}