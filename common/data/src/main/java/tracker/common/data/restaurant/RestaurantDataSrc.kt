package tracker.common.data.restaurant

import io.reactivex.Flowable
import tracker.common.data.model.RestaurantResponse
import tracker.common.data.network.api.ApiInterface

class RestaurantDataSrc(private val api: ApiInterface) {

    fun all(): Flowable<RestaurantResponse> {
        return api.restaurants()
    }

}