package com.tracker.app

import com.sha.kamel.navigator.NavigatorOptions
import com.tracker.app.di.KoinInjector
import tracker.common.core.CoreApp

class App : CoreApp() {
    override fun onCreate() {
        super.onCreate()
        KoinInjector.inject(this)
        NavigatorOptions.frameLayoutId = R.id.mainFrame
    }
}
