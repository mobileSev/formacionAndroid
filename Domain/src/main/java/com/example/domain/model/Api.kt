package com.example.domain.model

data class Api(

    val status: Int,
    val message: String,
    val results: Int,
    val filters: List<String>,
    val teams: List<Team>
)