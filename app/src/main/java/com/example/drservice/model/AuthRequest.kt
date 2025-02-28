package com.example.drservice.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(val token: String)
