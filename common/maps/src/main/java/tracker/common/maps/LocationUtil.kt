package tracker.common.maps

import android.Manifest
import android.location.Location
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.model.LatLng
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * Created by Sha on 1/7/18.
 */

object LocationUtil {

    val DEFAULT_LOCATION = "30.052983,31.334997"

    fun fromString(location: String): Location {
        val latLang = location.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return from(latLang[0], latLang[1])
    }

    fun from(lat: String, lng: String): Location {
        return from(LatLng(java.lang.Double.parseDouble(lat), java.lang.Double.parseDouble(lng)))
    }

    fun from(lat: Double, lng: Double): Location {
        return from(LatLng(lat, lng))
    }

    fun from(latLng: LatLng): Location {
        val location = Location("")
        location.latitude = latLng.latitude
        location.longitude = latLng.longitude
        return location
    }

    fun requestPermission(activity: FragmentActivity, isGranted: (Boolean) -> Unit) {
       val disposable = RxPermissions(activity).request(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { isGranted.invoke(it) }
    }

}
