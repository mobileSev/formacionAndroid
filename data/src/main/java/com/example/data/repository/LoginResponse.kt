package com.example.data.repository

sealed class LoginResponse(val status: String?) {
    data class Success(val success: String?) : LoginResponse(success)
    data class Error(val message: String?) : LoginResponse(message)
}