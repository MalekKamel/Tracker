package com.tracker.app

import com.sha.kamel.navigator.NavigatorOptions
import com.tracker.app.di.KoinInjector
import tracker.common.core.CoreApp
import tracker.common.core.util.CrashlyticsUtil

/**
 * Created by Sha on 13/04/17.
 */

class App : CoreApp() {

    override fun onCreate() {
        super.onCreate()
        try {

            context = applicationContext

            KoinInjector.inject(this)

            NavigatorOptions.frameLayoutId = R.id.mainFrame

        } catch (e: Exception) {
            CrashlyticsUtil.logAndPrint(e)
        }

    }

}
