package com.example.drservice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drservice.network.LinkRequest
import com.example.drservice.network.LinkResponse
import com.example.drservice.network.RetrofitInstance
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LinkViewModel : ViewModel() {
    private val _link = MutableStateFlow("")
    val link = _link.asStateFlow()

    private val _output = MutableStateFlow<String?>(null)
    val output = _output.asStateFlow()

    fun updateLink(newLink: String) {
        _link.value = newLink
    }

    fun sendLink() {
        if (_link.value.isNotBlank()) {
            _output.value = "Processing..."  // Show loading state

            viewModelScope.launch {
                try {
                    val response = RetrofitInstance.api.sendLink(_link.value)

                    if (response.isSuccessful) {
                        _output.value = response.body()?.toString() ?: "No response"
                    } else {
                        _output.value = "Error: ${response.code()} - ${response.message()}"
                    }
                } catch (e: HttpException) {
                    _output.value = "HTTP Error: ${e.message}"
                } catch (e: IOException) {
                    _output.value = "Network Error: Check Internet Connection"
                } catch (e: Exception) {
                    _output.value = "Error: ${e.message}"
                }
            }
        }
    }
}
