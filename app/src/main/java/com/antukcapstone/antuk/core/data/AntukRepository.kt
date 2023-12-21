package com.antukcapstone.antuk.core.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.liveData
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import com.antukcapstone.antuk.core.data.local.datastore.UserPreferences
import com.antukcapstone.antuk.core.data.remote.responses.auth.LoginResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.ProfileResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.RegisterResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.ResetPasswordResponse
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import java.lang.Exception

class AntukRepository(
    private val apiService: ApiService,
    private val preferences: UserPreferences
) {
    /* Auth API  */

    suspend fun saveLoggedInUser(user: UserModel) {
        preferences.saveLoggedInUser(user)
    }

    fun getLoggedInUser(): Flow<UserModel> {
        return preferences.getLoggedInUser()
    }

    suspend fun signOut() {
        preferences.signOut()
    }

    suspend fun register(fullName: String, phoneNumber: String, password: String, confirmPassword: String) = liveData{
        emit(ApiResult.Loading)
        try {
            val successResponse = apiService.register(fullName, phoneNumber, password, confirmPassword)
            emit(ApiResult.Success(successResponse))
        } catch (e:retrofit2.HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(ApiResult.Error(errorResponse.toString()))
        } catch (e:Exception) {
            emit(ApiResult.Error("Error Message :  ${e.message.toString()} "))
        }
    }

    suspend fun login(phoneNumber: String, password: String) = liveData {
        emit(ApiResult.Loading)
        try {
            val successResponse = apiService.login(phoneNumber, password)
            Log.d(TAG, successResponse.toString())

           emit(ApiResult.Success(successResponse))
        } catch (e: retrofit2.HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(ApiResult.Error(errorResponse.toString()))

        } catch (e: Exception) {
            emit(ApiResult.Error("Error Message : ${e.message.toString()}"))
        }
    }

    suspend fun editProfile(
        fullName: RequestBody,
        phoneNumber: RequestBody) = liveData {
        emit(ApiResult.Loading)

        try {
            val userSession = withContext(Dispatchers.IO) {
                preferences.getLoggedInUser().first()
            }
            val successResponse = apiService.editProfile(
                fullName = fullName,
                phoneNumber = phoneNumber,
                token = userSession.token
            )
            Log.d(TAG, successResponse.toString())

            emit(ApiResult.Success(successResponse))
        } catch (e: retrofit2.HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, ProfileResponse::class.java)
            emit(ApiResult.Error(errorResponse.toString()))
        } catch (e: Exception) {
            emit(ApiResult.Error("Error Message : ${e.message.toString()}"))
        }
    }

    suspend fun resetPassword(
        password: String,
        confirmPassword: String
    ) = liveData {
        emit(ApiResult.Loading)

        try {
            val userSession = withContext(Dispatchers.IO) {
                preferences.getLoggedInUser().first()
            }
            val successResponse = apiService.resetPassword(
                token = userSession.token,
                password,
                confirmPassword
            )
            Log.d(TAG, successResponse.toString())

            emit(ApiResult.Success(successResponse))
        } catch (e: retrofit2.HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, ResetPasswordResponse::class.java)
            emit(ApiResult.Error(errorResponse.toString()))
        } catch (e: Exception) {
            emit(ApiResult.Error("Error Message : ${e.message.toString()}"))
        }
    }

    companion object {
        @Volatile
        private var instance: AntukRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreferences: UserPreferences
        ): AntukRepository=
            instance ?: synchronized(this) {
                instance ?: AntukRepository(apiService, userPreferences)
            }.also { instance = it }
    }
}