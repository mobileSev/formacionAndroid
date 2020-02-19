package com.example.formacionandroid.di

import com.example.formacionandroid.ui.detail.DetailViewModel
import com.example.formacionandroid.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() = module {
        viewModel { DetailViewModel(get(), get()) }
        // viewModel { DetailViewModel(get()) }
        viewModel { LoginViewModel(get()) }
    }


}