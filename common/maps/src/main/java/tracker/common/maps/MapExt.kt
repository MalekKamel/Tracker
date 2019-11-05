package tracker.common.maps

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import com.google.maps.model.DirectionsResult
import com.google.maps.model.DirectionsRoute
import java.lang.StringBuilder

fun GoogleMap.drawRoute(
        result : DirectionsResult,
        overview: Int = 0,
        addMarkers: Boolean = true
) {
    if (result.routes.isEmpty()) return

    val route = result.routes[overview]

    val decodedPath = PolyUtil.decode(route.overviewPolyline.encodedPath)
    addPolyline(PolylineOptions().addAll(decodedPath))

    val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(
            route.legs[overview].startLocation.lat,
            route.legs[overview].startLocation.lng),
            7f
    )
    moveCamera(cameraUpdate)

    if (addMarkers) addMarkersToRoute(result = result)
}

fun GoogleMap.addMarkersToRoute(result: DirectionsResult, overview: Int = 0) {
    val leg = result.routes[overview].legs[overview]

    val m1 = MarkerOptions()
            .position(LatLng(leg.startLocation.lat, leg.startLocation.lng))
            .title(leg.startAddress)

    val snippet = MapRouteHelper.timeAndDistanceDescription(result)

    val m2 = MarkerOptions()
            .position(LatLng(leg.endLocation.lat, leg.endLocation.lng))
            .title(leg.endAddress)
            .snippet(snippet)

    addMarker(m1)
    addMarker(m2)
}

