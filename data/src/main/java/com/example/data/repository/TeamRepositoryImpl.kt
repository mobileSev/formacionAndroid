package com.example.data.repository

import android.app.Application
import android.util.Log
import com.example.common.Either
import com.example.common.TAG
import com.example.data.Response
import com.example.domain.Team
import com.example.domain.TeamError
import com.example.domain.TeamRepository

class TeamRepositoryImpl(private val androidApplication: Application) : TeamRepository {
    override suspend fun getTeam(): Either<TeamError, List<Team>> {
        Log.d(TAG, "TeamRepositoryImpl.getTeam")

        val teams =
            ServiceManager.service.getlistPopularTeamsAsync(/*apiKey, regionRepository*/)


        val response = if (teams.isSuccessful) {
            Log.d(TAG, "TeamRepositoryImpl.getTeam.isSuccessful")
            Response.Suscces(teams.body()?.teams as List<Team>)
        } else {
            Log.d(TAG, "TeamRepositoryImpl.getTeam.ERROR")

            Response.Error("ERROR MESSAGE TEAM")
        }
        return when (response) {
            is Response.Suscces -> Either.Right(teams.body()?.teams as List<Team>)
            is Response.Error -> Either.Left(TeamError("ERROR DE EQUIPOS"))
        }
    }
}

