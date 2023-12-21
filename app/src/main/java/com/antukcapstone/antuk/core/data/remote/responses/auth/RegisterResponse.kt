package com.antukcapstone.antuk.core.data.remote.responses.auth

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("data")
	val data: RegisterData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class RegisterData(

	@field:SerializedName("idUser")
	val idUser: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null
)
