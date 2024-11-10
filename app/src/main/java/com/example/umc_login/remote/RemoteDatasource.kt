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
        @Body loginRequest: LoginRequest  // 로그인 요청 데이터를 @Body로 전달
    ): LoginResponse

    @POST("join")
    suspend fun postJoin(
        @Body joinRequest: JoinRequest  // 회원가입 요청 데이터를 @Body로 전달
    ): JoinResponse

    @GET("test")
    suspend fun getJwtTest(@Header("Authorization") token: String): TestResponse
}

data class LoginRequest(
    @Query("email") val email: String,
    @Query("password") val password: String
)

data class JoinRequest(
    @Query("name") val name: String,
    @Query("email") val email: String,
    @Query("password") val password: String
)
