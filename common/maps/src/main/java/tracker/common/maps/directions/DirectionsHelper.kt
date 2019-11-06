package tracker.common.maps.directions

import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import tracker.common.core.CoreApp
import tracker.common.maps.R
import java.util.concurrent.TimeUnit

object DirectionsHelper {

     fun directions(origin: String, destination: String, mode: TravelMode): DirectionsResult {
        val geoApiContext =  GeoApiContext.Builder()
                .queryRateLimit(3)
                .apiKey(CoreApp.string(R.string.geo_api_code))
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build()

       return DirectionsApi.newRequest(geoApiContext)
                .mode(mode)
                .origin(origin)
                .destination(destination)
                .departureTimeNow()
                .await()
    }

}