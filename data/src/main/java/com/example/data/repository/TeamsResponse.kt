package com.example.data.repository

import com.example.domain.Team

class TeamsResponse(
    val status: Int,
    val message: String,

    val results: Int,
    val filters: List<String>,

    val teams: List<Team>?

)