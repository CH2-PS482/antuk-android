package com.antukcapstone.antuk.ui.screens.account.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.remote.responses.auth.RegisterResponse
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: AntukRepository): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    var fullName by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    private val _send = MutableLiveData<ApiResult<RegisterResponse>>()
    val send: LiveData<ApiResult<RegisterResponse>> = _send

    fun sendRegisterData(
        fullName: String,
        phoneNumber: String,
        password: String,
        confirmPassword: String,
    ) {
        viewModelScope.launch {
            try {
                _isLoading.postValue(true)
                repository.register(fullName, phoneNumber, password, confirmPassword).asFlow().collect() {
                    _send.value = it
                }
            } finally {
                _isLoading.postValue(false)
            }
        }
    }


}