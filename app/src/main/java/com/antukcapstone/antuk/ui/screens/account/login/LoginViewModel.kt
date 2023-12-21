package com.antukcapstone.antuk.ui.screens.account.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import com.antukcapstone.antuk.core.data.remote.responses.auth.LoginResponse

import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AntukRepository,
): ViewModel() {

    var phoneNumber by mutableStateOf("")
    var password by mutableStateOf("")

    private val _send = MutableLiveData<ApiResult<LoginResponse>>()
    val send: MutableLiveData<ApiResult<LoginResponse>> = _send

    fun saveLoggedInUser(user: UserModel) {
        viewModelScope.launch() {
            repository.saveLoggedInUser(user)
        }
    }

    fun sendLoginData(
        phoneNumber: String,
        password: String
    ) {
        viewModelScope.launch {
            repository.login(phoneNumber,password).asFlow().collect{
                _send.value = it
            }
        }
    }

}