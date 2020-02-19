package com.example.formacionandroid

import android.app.Application

class TeamsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        /*startKoin {
            modules(
                listOf(
                    DataKoinConfiguration().getModule(),
                    DomainKoinConfiguration().getModule(),
                    PresentationKoinConfiguration().getModule()
                )
            )
        }*/
    }
}