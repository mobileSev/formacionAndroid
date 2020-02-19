package com.example.formacionandroid.di

import com.example.formacionandroid.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class PresentationKoinConfiguration {

    fun getModule() =  module{

        viewModel { MainViewModel(get()) }
    }

}