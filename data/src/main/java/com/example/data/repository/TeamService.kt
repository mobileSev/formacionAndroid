package com.example.data.repository

import retrofit2.Response
import retrofit2.http.GET

interface TeamService {
    @GET("teams")
    suspend fun getlistPopularTeamsAsync(
//        @Query("api_key") apiKey: String,
//        @Query("region") region: String
    ): Response<TeamResponse>
}