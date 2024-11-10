package com.example.umc_login.remote

import com.example.umc_login.response.JoinResponse
import com.example.umc_login.response.LoginResponse
import com.example.umc_login.response.TestResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface RemoteDatasource {
    @POST("login")
    suspend fun postLogin(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginResponse

    @POST("join")
    suspend fun postJoin(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): JoinResponse

    @GET("test")
    suspend fun getJwtTest(@Header("Authorization") token: String): TestResponse
}