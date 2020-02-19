package com.example.domain.di

import com.example.domain.useCases.GetTeam
import org.koin.dsl.module.module

class DomainKoinConfiguration {
    fun getModule() = module {
        factory { GetTeam(get()) }

    }
}