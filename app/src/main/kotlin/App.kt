package com.oleeja.reditclient

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import reditclient.di.dataSourceModule
import reditclient.di.retrofitNetworkModule
import reditclient.top.topRedditInteractorModule
import reditclient.top.topRedditRepositoryModule
import reditclient.top.topRedditViewModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(dataSourceModule + retrofitNetworkModule)
            modules(topRedditViewModule + topRedditInteractorModule + topRedditRepositoryModule)
        }
    }
}