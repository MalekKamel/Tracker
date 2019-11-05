package tracker.feature.head

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import restaurants.feature.head.R


class AppHead : Service() {

    private var mWindowManager: WindowManager? = null
    private lateinit var head: AppHeadView

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        setupHead()
    }

    private fun setupHead() {
        //Inflate the chat head layout we created
        head = LayoutInflater.from(this).inflate(R.layout.app_head, null) as AppHeadView

        head.onDismiss =  { stopSelf() }

        head.findViewById<View>(R.id.btnDismiss).setOnClickListener { stopSelf() }

        mWindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mWindowManager?.addView(head, head.params)
    }

    override fun onDestroy() {
        super.onDestroy()
        mWindowManager?.removeView(head)
    }

}