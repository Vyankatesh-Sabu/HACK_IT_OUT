package com.example.drservice.network

import com.example.drservice.model.AuthRequest
import com.example.drservice.model.CommentResponse
import com.example.drservice.model.FirstLoginRequest
import com.example.drservice.model.LoginRequest
import com.example.drservice.model.LoginResponse
import com.example.drservice.model.ProtectedResponse
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

data class LinkRequest(val link: String) // Request model
data class LinkResponse(val result: String) // Response model


interface ApiService {
    @POST("api/user/sign-in")
    suspend fun login(@Body request: LoginRequest): retrofit2.Response<LoginResponse>

    @POST("api/user/sign-up")
    suspend fun login(@Body request: FirstLoginRequest): retrofit2.Response<LoginResponse>

    @POST("api/user/profile")
    suspend fun getProtectedData(@Body request: AuthRequest): ProtectedResponse

    @GET("api/user/comments")
    suspend fun sendLink(@Query("url") link: String): retrofit2.Response<CommentResponse>
}
