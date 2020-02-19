package com.example.formacionandroid

import android.app.Application
import com.example.data.di.DataKoinConfiguration
import com.example.domain.di.DomainKoinConfiguration
import com.example.formacionandroid.di.PresentationKoinConfiguration

import org.koin.core.context.startKoin

class TeamsApplication :  Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    DataKoinConfiguration().getModule(),
                    DomainKoinConfiguration().getModule(),
                    PresentationKoinConfiguration().getModule()
                )
            )
        }
    }
}