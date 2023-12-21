package com.antukcapstone.antuk.core.data.remote.retrofit



import com.antukcapstone.antuk.core.data.remote.responses.app.HistoryResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.LoginResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.ProfileResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.RegisterResponse
import com.antukcapstone.antuk.core.data.remote.responses.auth.ResetPasswordResponse
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ApiService {

    // Authentication
    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("fullName") fullName: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String,
        ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): LoginResponse

    // Profile
    @GET("profile")
    suspend fun profile(
        @Header("Authorization") token: String,
        @Path("idUser") idUser: String,
        @Path("phoneNumber") phoneNumber: String,
        @Path("fullName") fullName: String
    ): ProfileResponse

    @FormUrlEncoded
    @PATCH("profile/edit")
    suspend fun editProfile(
        @Header("Authorization") token: String,
        @Field("phoneNumber") phoneNumber: RequestBody,
        @Field("fullName") fullName: RequestBody
    ): ProfileResponse

    // Password
    @FormUrlEncoded
    @PUT("profile/reset_password")
   suspend fun resetPassword(
        @Header("Authorization") token: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String
    ): ResetPasswordResponse

    // History
    @FormUrlEncoded
    @POST("history")
    suspend fun addHistory(
        @Header("Authorization") token: String,
//        @Field("date") date: String ,
//        @Field("duration") duration: String,
//        @Field("totalWarning") totalWarning: Int
    ): HistoryResponse
}