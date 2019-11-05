package tracker.common.maps.geocode

/**
 * Created by Sha on 1/16/18.
 */

interface GeocodeStatus {
    companion object {
        val OK = "OK"
        val ZERO_RESULTS = "ZERO_RESULTS"
        val OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT"
        val REQUEST_DENIED = "REQUEST_DENIED"
        val INVALID_REQUEST = "INVALID_REQUEST"
        val UNKNOWN_ERROR = "UNKNOWN_ERROR"
    }
}
