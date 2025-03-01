package com.example.drservice.model

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val statusCode: Int,
    val data: CommentData?,
    val message: String,
    val success: Boolean
)

@Serializable
data class CommentData(
    val url: String?,
    val comments: List<String>?
)



