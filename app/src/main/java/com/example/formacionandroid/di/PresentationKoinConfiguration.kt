package com.example.formacionandroid.di

import com.example.formacionandroid.ui.detail.DetailViewModel
import com.example.formacionandroid.ui.login.LoginViewModel
import com.example.formacionandroid.ui.teams.TeamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() = module {
        viewModel { DetailViewModel(get(), get()) }
        viewModel { TeamsViewModel(get()) }
        viewModel { LoginViewModel(get()) }
    }


}