package com.antukcapstone.antuk.core.data.remote.responses.auth

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(

	@field:SerializedName("message")
	val message: String? = null
)
