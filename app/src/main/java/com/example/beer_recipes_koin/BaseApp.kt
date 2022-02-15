package com.example.beer_recipes_koin

import android.app.Application
import com.example.beer_recipes_koin.di.dataModule
import com.example.beer_recipes_koin.di.domainModule
import com.example.beer_recipes_koin.di.presentationModule
import com.example.beer_recipes_koin.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp :Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApp)
            androidLogger(Level.DEBUG)
            modules(listOf(retrofitModule, dataModule, domainModule, presentationModule))
        }
    }
}