package com.example.domain.model

data class Team(

    val city: String,
    val fullName: String,
    val teamId: String,
    val nickname: String,
    val logo: String,
    val shortName: String,
    val allStar: Int,
    val nbaFranchise: Int,
    val leagues: Standard
)