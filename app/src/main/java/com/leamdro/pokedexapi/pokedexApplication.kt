package com.leamdro.pokedexapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class pokedexApplication : Application() {
    override  fun onCreate(){
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}