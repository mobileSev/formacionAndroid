package com.example.domain

import com.example.common.Either

interface TeamRepository {
    suspend fun getTeam(): Either<TeamError, List<Team>>

}