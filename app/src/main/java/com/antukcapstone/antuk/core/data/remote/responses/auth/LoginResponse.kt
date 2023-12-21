package com.antukcapstone.antuk.core.data.remote.responses.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val loginData: LoginData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class LoginData(

	@field:SerializedName("idUser")
	val idUser: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
