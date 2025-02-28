package com.example.drservice.model

import kotlinx.serialization.Serializable

@Serializable
data class ProtectedResponse(
    val message: String,
    val data: SecureData
)

@Serializable
data class SecureData(
    val info: String
)

