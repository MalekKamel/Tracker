package tracker.feature.head

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.view.WindowManager

abstract class AbstractHeadService : Service() {

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
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.removeView(head)
    }

}