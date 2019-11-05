package tracker.common.maps

import androidx.fragment.app.Fragment
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class GoogleMapSetup {
    private var mGoogleApiClient: GoogleApiClient? = null
    var map: GoogleMap? = null
    var onMapReady: ((GoogleMap) -> Unit)? = null

    fun setup(frag: Fragment, mapRes: Int) {
        val mapFragment = frag.childFragmentManager.findFragmentById(mapRes) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            map = googleMap
            onMapReady?.invoke(googleMap)
        }
    }

    fun connect() {
            mGoogleApiClient?.connect()
    }

    fun disconnect() {
        mGoogleApiClient?.disconnect()
    }

}