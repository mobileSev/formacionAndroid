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

    override suspend fun showTeam(team: Team): Either<TeamError, Team> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d(TAG, "TeamRepositoryImpl.showTeam")


        val response: TeamResponse = if (team != null) {
            Log.d(TAG, "TeamRepositoryImpl.showTeam.isSuccessful")
            TeamResponse.Success(team)
        } else {
            Log.d(TAG, "TeamRepositoryImpl.showTeam.ERROR")

            TeamResponse.Error("ERROR MESSAGE showTeam")
        }
        return when (response) {
            is TeamResponse.Success -> Either.Right(team)
            is TeamResponse.Error -> Either.Left(TeamError("ERROR DE showTeam"))
        }
    }

    override suspend fun deleteTeam(team: Team): Either<TeamError, List<Team>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d(TAG, "TeamRepositoryImpl.deleteTeam")
    }

    override suspend fun addTeam(team: Team): Either<TeamError, List<Team>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d(TAG, "TeamRepositoryImpl.addTeam")
    }
}

