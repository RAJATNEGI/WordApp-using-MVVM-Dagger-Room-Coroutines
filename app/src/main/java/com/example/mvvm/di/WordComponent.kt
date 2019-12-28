package com.example.mvvm.di

import com.example.mvvm.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [],modules = [DbModule::class])
interface WordComponent {
    fun inject(mainActivity: MainActivity)
//    fun appDatabase(): AppDatabase
}