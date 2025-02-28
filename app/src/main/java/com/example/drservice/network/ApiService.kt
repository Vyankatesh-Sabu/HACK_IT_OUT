package com.example.drservice.network

import com.example.drservice.model.AuthRequest
import com.example.drservice.model.LoginRequest
import com.example.drservice.model.LoginResponse
import com.example.drservice.model.ProtectedResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/user/sign-in")
    suspend fun login(@Body request: LoginRequest): retrofit2.Response<LoginResponse>

    @POST("auth/protected-data")
    suspend fun getProtectedData(@Body request: AuthRequest): ProtectedResponse
}
