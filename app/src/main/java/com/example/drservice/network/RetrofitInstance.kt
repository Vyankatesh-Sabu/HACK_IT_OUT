package com.example.drservice.network

import android.window.BackEvent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
//    private const val BASE_URL = "https://hackitout-backend.onrender.com"
//    private const val BASE_URL = "http://192.168.155.33:8000"
    private const val BASE_URL = "https://l2nc0pxn-8000.inc1.devtunnels.ms"
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://hackitout-backend.onrender.com") // Use your API base URL
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }



//    val api: ApiService by lazy { retrofit.create(ApiService::class.java) }
private val client = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
