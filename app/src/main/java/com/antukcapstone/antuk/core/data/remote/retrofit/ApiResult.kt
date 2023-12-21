package com.antukcapstone.antuk.core.data.remote.retrofit

sealed class ApiResult<out T: Any?> () {
    data class Success<out T: Any>(val data: T) : ApiResult<T>()

    data class Error(val errorMessage: String) : ApiResult<Nothing>()

    object Loading : ApiResult<Nothing>()
}