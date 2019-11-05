package tracker.feature.map

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import tracker.common.maps.LocationUtil

object Fake {

    const val destination = "31.084547,29.883529"

    fun latLng(): LatLng {
        return LatLng(31.084547, 29.883529)
    }

    fun location(): Location {
        return LocationUtil.from(28.951933, 30.841700)
    }

}