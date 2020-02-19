package com.example.data.repository

import com.example.domain.Team


sealed class TeamResponse() {
    data class Success(val team: Team?) : TeamResponse()
    data class Error(val message: String) : TeamResponse()
}
