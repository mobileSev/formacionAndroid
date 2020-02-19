package com.example.formacionandroid

import android.app.Application
import android.util.Log
import com.example.common.TAG
import com.example.data.di.DataKoinConfiguration
import com.example.domain.di.DomainKoinConfiguration
import com.example.formacionandroid.di.PresentationKoinConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TeamsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "TeamsApplication.onCreate")
        startKoin {
            androidContext(this@TeamsApplication)
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