package com.tracker.app

import android.os.Bundle
import com.sha.kamel.navigator.FragmentNavigator
import tracker.common.presentation.activity.BaseActivity
import tracker.feature.map.MapFrag

class MainActivity : BaseActivity() {

    override var layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            FragmentNavigator(this)
                    .replace(MapFrag.newInstance(), false)
    }
}
