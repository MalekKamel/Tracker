package com.tracker.app

import android.os.Bundle
import com.sha.kamel.navigator.FragmentNavigator
import tracker.common.presentation.activity.BaseActivity
import tracker.feature.head.AppHead
import tracker.feature.splash.SplashFrag

class MainActivity : BaseActivity() {

    override var layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            FragmentNavigator(this)
                    .replace(SplashFrag.newInstance(), false)
    }

    override fun onStart() {
        super.onStart()
        AppHead.hide()
    }

    override fun onPause() {
        super.onPause()
        AppHead.show(this)
    }

}
