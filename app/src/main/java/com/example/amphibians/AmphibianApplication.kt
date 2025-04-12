package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.AppContainer
import com.example.amphibians.data.DefaultAppContainer

class AmphibianApplication : Application() {

    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }
}