package com.example.domain.useCases

import com.example.common.Either
import com.example.domain.Team
import com.example.domain.TeamError
import com.example.domain.TeamRepository

class GetTeam(private val repository: TeamRepository) {
    suspend fun invoke(): Either<TeamError, List<Team>> = repository.getTeam()

}