package com.example.drservice.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drservice.data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val context: Context) : ViewModel() {
    private val authRepository = AuthRepository(context)

    private val _authState = MutableStateFlow<Result<String>?>(null)
    val authState: StateFlow<Result<String>?> = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = runCatching {
                kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                    authRepository.login(email, password).getOrThrow()
                }
            }
        }
    }

    fun fetchProtectedData() {
        viewModelScope.launch {
            _authState.value = authRepository.getProtectedData()
        }
    }
}