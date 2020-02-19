package com.example.domain.useCases

import com.example.common.Either
import com.example.domain.Team
import com.example.domain.TeamError
import com.example.domain.TeamRepository

class ShowTeam(private val repository: TeamRepository) {
    // It doesn't make sense to have this Use Case as suspend fun, but it's a coroutine practice
    suspend fun invoke(team: Team): Either<TeamError, Team> = repository.showTeam(team)
}