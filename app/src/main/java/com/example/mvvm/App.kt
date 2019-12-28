package com.example.mvvm

import android.app.Application
import com.example.mvvm.di.DaggerWordComponent
import com.example.mvvm.di.DbModule

import com.example.mvvm.di.WordComponent

class App : Application() {

    private lateinit var component: WordComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerWordComponent.builder().dbModule(DbModule(this)).build()
    }

    fun getComponent(): WordComponent {
        return component
    }
}