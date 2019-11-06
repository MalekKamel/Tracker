package tracker.common.maps

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import tracker.common.core.util.StringBuilderUtil

/**
 * Created by Sha on 1/7/18.
 */

object LocationUtil {

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

}

fun Location.commaSeparated(): String {
    return StringBuilderUtil()
            .append(latitude)
            .comma()
            .append(longitude)
            .toString()
}

fun LatLng.commaSeparated(): String {
    return StringBuilderUtil()
            .append(latitude)
            .comma()
            .append(longitude)
            .toString()
}

fun from(location: Location): LatLng {
    return LatLng(location.latitude, location.longitude)
}