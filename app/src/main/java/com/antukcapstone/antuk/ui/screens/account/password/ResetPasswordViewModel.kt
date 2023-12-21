package com.antukcapstone.antuk.ui.screens.account.password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.remote.responses.auth.ResetPasswordResponse
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import kotlinx.coroutines.launch

class ResetPasswordViewModel(private val repository: AntukRepository): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    private val _send = MutableLiveData<ApiResult<ResetPasswordResponse>>()
    val send: LiveData<ApiResult<ResetPasswordResponse>> = _send

    fun sendResetPasswordData(
        password: String,
        confirmPassword: String
    ) {
        viewModelScope.launch {
            try {
                _isLoading.postValue(true)
                repository.resetPassword(password, confirmPassword)
                    .asFlow().collect() {
                        _send.value = it
                    }

            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}