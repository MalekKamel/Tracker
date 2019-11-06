package com.tracker.app

import com.sha.kamel.navigator.NavigatorOptions
import com.tracker.app.di.KoinInjector
import tracker.common.core.CoreApp
import tracker.common.core.util.CrashlyticsLogger

class App : CoreApp() {
    override fun onCreate() {
        super.onCreate()
        try {
            context = applicationContext

            KoinInjector.inject(this)

            NavigatorOptions.frameLayoutId = R.id.mainFrame

        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }
}
