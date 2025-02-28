package com.example.drservice.model

data class LoginResponse(
    val data: Data
) {
    data class Data(
        val token: String
    )
}
