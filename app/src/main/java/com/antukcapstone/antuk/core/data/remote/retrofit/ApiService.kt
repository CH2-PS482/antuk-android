package com.antukcapstone.antuk.core.data.remote.retrofit


import com.antukcapstone.antuk.core.data.remote.responses.LoginResponse
import com.antukcapstone.antuk.core.data.remote.responses.ProfileResponse
import com.antukcapstone.antuk.core.data.remote.responses.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // Authentication
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("fullName") fullName: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    // Profile
    @GET("profile")
    fun profile(
        @Header("Authorization") token: String,
        @Path("phoneNumber") phoneNumber: String,
        @Path("fullName") fullName: String
    ): Call<ProfileResponse>
}