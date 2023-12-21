package com.antukcapstone.antuk.ui.screens.account.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.antukcapstone.antuk.core.data.AntukRepository
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import com.antukcapstone.antuk.core.data.remote.responses.auth.ProfileResponse
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import okhttp3.RequestBody

class EditProfileViewModel(private val repository: AntukRepository): ViewModel() {

    var fullName by mutableStateOf("")
    var phoneNumber by mutableStateOf("")

    fun getLoggedInUser() : LiveData<UserModel> {
        return repository.getLoggedInUser().asLiveData()
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    suspend fun editDataProfile(
        fullName: RequestBody,
        phoneNumber: RequestBody
    ): LiveData<ApiResult<ProfileResponse>> {
        return repository.editProfile(
            fullName = fullName,
            phoneNumber = phoneNumber
        )

    }

}