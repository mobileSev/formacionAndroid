package com.example.domain.useCases

import com.example.common.Either
import com.example.domain.model.Team
import com.example.domain.TeamError
import com.example.domain.TeamRepository

class DeleteTeam(private val repository: TeamRepository) {
    suspend fun invoke(team: Team): Either<TeamError, List<Team>?> =
        repository.deleteTeam(team)
}

