package com.antukcapstone.antuk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: AntukRepository): ViewModel() {

    private val mutableStateFlow = MutableStateFlow(true)
    val isLoading = mutableStateFlow.asStateFlow()

    private val _loginState = MutableStateFlow<UserModel?>(null)
    val loginState: StateFlow<UserModel?> get() = _loginState

    init {
        getLoggedInUser()
    }
    fun saveLoggedInUser(user: UserModel) {
        viewModelScope.launch {
            repository.saveLoggedInUser(user)
        }
    }

    fun getLoggedInUser() {
        viewModelScope.launch {
            repository.getLoggedInUser().collect {
                _loginState.value = it
            }
        }
    }
}