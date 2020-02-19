package com.example.domain

import com.example.common.Either

interface TeamRepository {
    suspend fun getMovie(error: Boolean): Either<TeamError, List<Team>>

}