package com.example.pokeapi.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokeApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}