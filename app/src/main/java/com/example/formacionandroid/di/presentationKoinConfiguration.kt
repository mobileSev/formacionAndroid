package com.example.formacionandroid.di

import com.example.formacionandroid.ui.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PresentationKoinConfiguration {

    fun getModule() =  module{

       // viewModel { DetailViewModel(get()) }
    }

}