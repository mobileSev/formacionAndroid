package com.example.data

import com.example.domain.Team

sealed class Response {
    data class Suscces(val suscces: List<Team>?) : Response()
    data class Error(val message: String) : Response()
}