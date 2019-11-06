package tracker.common.maps.service

import android.Manifest
import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import tracker.common.core.util.PermissionHelper
import tracker.common.core.util.ServiceHelper
import tracker.common.maps.LocationRetriever
import tracker.common.maps.commaSeparated
import java.util.concurrent.TimeUnit

class LocationTrackerService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        ServiceHelper.showTripRunningForeground(this)
        scheduleLocationUpdate()
    }

    private fun scheduleLocationUpdate() {
        Handler().postDelayed(
                { sendLocation() },
                TimeUnit.SECONDS.toMillis(30)
        )
    }

    private fun sendLocation() {
        LocationRetriever().retrieve {
            Toast.makeText(
                    this,
                    "Sent Location ${it.commaSeparated()} to server!",
                    Toast.LENGTH_LONG
            ).show()
            scheduleLocationUpdate()
        }
    }

    companion object {
        fun startIfPermissionGranted(activity: Activity) {
            val permissions = setOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            )
            if (!PermissionHelper.isAnyGranted(permissions, activity)) return
            ServiceHelper.startForegroundService(LocationTrackerService::class.java)
        }
    }
}