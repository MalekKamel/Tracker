package tracker.common.maps

import android.location.Location

import com.google.android.gms.maps.model.LatLng
import tracker.common.core.util.StringBuilderUtil

/**
 * Created by Sha on 1/7/18.
 */


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
