package com.example.umc_login.response

data class JoinResponse(
    val isSuccess: Boolean?,
    val code: String?,
    val message: String?,
    val result: Result?
) {
    data class Result(
        val memberId: Int?,
        val createdAt: String?,
        val updatedAt: String?
    )
}

data class LoginResponse(
    val isSuccess: Boolean?,
    val code: String?,
    val message: String?,
    val result: Result?
) {
    data class Result(
        val memberId: Int?,
        val accessToken: String?
    )
}

data class TestResponse(
    val isSuccess: Boolean?,
    val code: String?,
    val message: String?,
    val result: String?
)







