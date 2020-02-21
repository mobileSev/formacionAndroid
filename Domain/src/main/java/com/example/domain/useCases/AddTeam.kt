package com.example.domain.useCases

import com.example.common.Either
import com.example.domain.model.Team
import com.example.domain.TeamError
import com.example.domain.TeamRepository

class AddTeam(private val repository: TeamRepository) {
    suspend fun invoke(team: Team): Either<TeamError, List<Team>?> =
        repository.addTeam(team)

}