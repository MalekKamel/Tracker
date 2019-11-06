package tracker.common.maps.directions

import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import io.reactivex.Single

object RxDirectionsApi {

    fun directions(
            origin: String,
            destination: String,
            mode: TravelMode
    ): Single<DirectionsResult> {
        return Single.defer {
            Single.just(DirectionsHelper.directions(origin, destination, mode))
        }
    }

}