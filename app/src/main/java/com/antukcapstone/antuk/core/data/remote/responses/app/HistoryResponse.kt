package com.antukcapstone.antuk.core.data.remote.responses.app

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("message")
	val message: String? = null
)

data class GetHistoryResponse(

	@field:SerializedName("data")
	val historyData: List<List<HistoryData?>?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class HistoryData(

	@field:SerializedName("idUser")
	val idUser: String? = null,

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("idHistory")
	val idHistory: String? = null,

	@field:SerializedName("totalWarnings")
	val totalWarnings: Int? = null
)
