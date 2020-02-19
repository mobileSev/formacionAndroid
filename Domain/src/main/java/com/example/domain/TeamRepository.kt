package com.example.domain

import com.example.common.Either

interface TeamRepository {
    suspend fun getTeam(): Either<TeamError, List<Team>>
    suspend fun showTeam(team: Team): Either<TeamError, Team>
    suspend fun deleteTeam(team: Team): Either<TeamError, List<Team>>
    suspend fun addTeam(team: Team): Either<TeamError, List<Team>>

}