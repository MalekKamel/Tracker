package tracker.common.maps

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by Sha on 1/7/18.
 */

fun GoogleMap.add(
        location: LatLng,
        title: String,
        zoom: Boolean): Marker {
    val marker = addMarker(
            MarkerOptions()
                    .position(location)
                    .flat(true)
                    .anchor(0.5f, 0.5f)
                    .title(title)
    )
    if (zoom) moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
    return marker
}

