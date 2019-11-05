package com.tracker.app.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tracker.common.data.di.injectPresentationModule

object KoinInjector {

    fun inject(context: Context){
        startKoin {
            androidContext(context)
        }
        injectPresentationModule()
    }

}