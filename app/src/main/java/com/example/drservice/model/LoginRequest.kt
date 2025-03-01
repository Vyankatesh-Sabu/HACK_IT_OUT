package com.example.drservice.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val email: String, val password: String)

@Serializable
data class FirstLoginRequest(val email: String, val password: String)