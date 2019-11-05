package tracker.common.maps

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.*
import com.sha.kamel.rxlocation.UpdateQuality


class LocationRetriever {
    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var locationCallback: LocationCallback? = null


    @SuppressLint("MissingPermission")
    fun retrieve(context: Context, callback: (Location) -> Unit) {
        GoogleApiClientUtil().create(
                context,
                {
                    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
                    fusedLocationProviderClient!!.lastLocation
                            .addOnSuccessListener { location ->
                                // Got last known location. In some rare situations, this can be null.
                                if (location != null) {
                                    callback(location)
                                    return@addOnSuccessListener
                                }
                                requestLocationUpdate(callback)
                            }
                            .addOnFailureListener { it.printStackTrace() }
                },
                LocationServices.API)
    }

    @SuppressLint("MissingPermission", "CheckResult")
    private fun requestLocationUpdate(callback: (Location) -> Unit) {
        try {

            val locationRequest = LocationRequest()
            locationRequest.priority = UpdateQuality().priority
            locationRequest.interval = UpdateQuality().interval
            locationRequest.fastestInterval = UpdateQuality().fastestUpdateInterval

            locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult?) {
                    super.onLocationResult(locationResult)
                    callback(locationResult!!.lastLocation)
                    removeLocationUpdates()
                }
            }

            fusedLocationProviderClient!!.requestLocationUpdates(
                    locationRequest,
                    locationCallback!!, null)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun removeLocationUpdates() {
        if (fusedLocationProviderClient != null && locationCallback != null)
            fusedLocationProviderClient!!.removeLocationUpdates(locationCallback!!)
    }

}
