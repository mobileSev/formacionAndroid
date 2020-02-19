package com.example.data.di

import com.example.data.repository.TeamRepositoryImpl
import com.example.domain.TeamRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

class DataKoinConfiguration {
    fun getModule() = module {
        // repository needs to be a singleton
        single<TeamRepository> { TeamRepositoryImpl(androidApplication()) }

    }
}