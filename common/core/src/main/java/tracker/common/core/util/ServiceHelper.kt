package tracker.common.core.util

import android.app.Service
import android.content.Intent
import android.os.Build

import androidx.core.content.ContextCompat
import tracker.common.core.CoreApp


/**
 * Created by Sha on 10/13/17.
 */

object ServiceHelper {

    fun startForegroundService(clazz: Class<*>) {
        try {
            ContextCompat.startForegroundService(CoreApp.context, Intent(CoreApp.context, clazz))
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }

    fun startForegroundService(intent: Intent) {
        try {
            ContextCompat.startForegroundService(CoreApp.context, intent)
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }

    fun showTripRunningForeground(service: Service) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            service.startForeground(1, NotificationHelper.tripRunning())
    }


    fun start(clazz: Class<*>) {
        try {
            CoreApp.context.startService(Intent(CoreApp.context, clazz))
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }
    fun start(intent: Intent) {
        try {
            CoreApp.context.startService(intent)
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }

    fun stop(clazz: Class<*>) {
        try {
            CoreApp.context.stopService(Intent(CoreApp.context, clazz))
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }

    }
}
