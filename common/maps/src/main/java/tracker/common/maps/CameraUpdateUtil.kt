package tracker.common.maps

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng

/**
 * Created by Sha on 1/16/18.
 */

object CameraUpdateUtil {

    fun newLatLngZoom(latLng: LatLng, map: GoogleMap, zoom: Int) {
        val cameraUpdate = CameraUpdateFactory
                .newLatLngZoom(
                        latLng,
                        zoom.toFloat())
        map.animateCamera(cameraUpdate)
    }
}
