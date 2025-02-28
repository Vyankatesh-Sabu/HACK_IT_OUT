package com.example.drservice.data

import android.content.Context
import android.util.Log
import com.example.drservice.model.LoginRequest
import com.example.drservice.model.LoginResponse
import com.example.drservice.network.RetrofitInstance
import com.example.drservice.model.AuthRequest
import retrofit2.Response

class AuthRepository(private val context: Context) {
    suspend fun login(email: String, password: String): Result<String> {
        return try {
            val response: Response<LoginResponse> = RetrofitInstance.api.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    val token = loginResponse.data.token
                    Log.d("AuthRepository", "Token received: $token")
                    SecureStorage.saveToken(context, token)
                    Result.success("Login successful")
                } else {
                    Result.failure(Exception("Login response is null"))
                }
            } else {
                Result.failure(Exception("Login failed with status code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Log.e("AuthRepository", "Login failed", e)
            Result.failure(e)
        }
    }

    suspend fun getProtectedData(): Result<String> {
        val token = SecureStorage.getToken(context) ?: return Result.failure(Exception("No token found"))
        return try {
            val response = RetrofitInstance.api.getProtectedData(AuthRequest(token))
            Result.success(response.data.info)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}