package tracker.common.maps

import android.annotation.SuppressLint
import android.content.Context
import android.location.GnssStatus
import android.location.GpsStatus.GPS_EVENT_STARTED
import android.location.GpsStatus.GPS_EVENT_STOPPED
import android.location.LocationManager
import android.os.Build
import androidx.fragment.app.FragmentActivity
import tracker.common.core.util.CrashlyticsUtil

/**
 * Created by Sha on 1/7/18.
 */

object LocationManagerUtil {

    fun isLocationServiceEnabled(context: Context, callback: ((Boolean) -> Unit)? = null): Boolean {
        try {
            val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

            val gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val networkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            val isEnabled = gpsEnabled || networkEnabled

            callback?.invoke(isEnabled)

            return isEnabled
        } catch (e: Exception) {
            e.printStackTrace()
            CrashlyticsUtil.log(e)
        }

        return false
    }

    @SuppressLint("MissingPermission")
    fun listenForGpsStatus(context: Context, activity: FragmentActivity, callback: (Boolean) -> Unit) {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        LocationUtil.requestPermission(activity
        ) { isGranted ->
            if (!isGranted) return@requestPermission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                locationManager.registerGnssStatusCallback(object : GnssStatus.Callback() {
                    override fun onStarted() {
                        super.onStarted()
                    }

                    override fun onStopped() {
                        super.onStopped()
                    }
                })
            } else {
                locationManager.addGpsStatusListener { event ->
                    when (event) {
                        GPS_EVENT_STARTED -> callback.invoke(true)

                        GPS_EVENT_STOPPED -> callback.invoke(false)
                    }
                }
            }
        }
    }

}
