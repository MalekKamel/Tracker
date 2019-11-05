package tracker.common.data.restaurant

import io.reactivex.Flowable
import tracker.common.data.base.BaseRepo
import tracker.common.data.model.RestaurantResponse

class RestaurantsRepo(private val restaurantDataSrc: RestaurantDataSrc): BaseRepo() {

    fun all(): Flowable<RestaurantResponse> {
        return restaurantDataSrc.all()
    }


}
