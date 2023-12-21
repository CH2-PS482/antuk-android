package com.antukcapstone.antuk.core.data.remote.responses.auth

import com.google.gson.annotations.SerializedName

data class ProfileResponse(

	@field:SerializedName("data")
	val data: ProfileData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ProfileData(

	@field:SerializedName("idUser")
	val idUser: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null
)
