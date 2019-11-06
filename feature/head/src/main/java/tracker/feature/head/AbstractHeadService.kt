package tracker.feature.head

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.view.View
import android.view.WindowManager
import restaurants.feature.head.R

abstract class AbstractHeadService : Service() {

    var mWindowManager: WindowManager? = null
    lateinit var head: AppHeadView

    abstract val layoutId: Int

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        setupHead()
    }

    private fun setupHead() {
        head = AppHeadView.show(this, layoutId)
        setupHeadView(head)
    }

    abstract fun setupHeadView(head: AppHeadView)

    override fun onDestroy() {
        super.onDestroy()
        mWindowManager?.removeView(head)
    }

}