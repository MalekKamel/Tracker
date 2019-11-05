package tracker.common.data

import tracker.common.data.pref.SharedPref
import tracker.common.data.restaurant.RestaurantsRepo

open class DataManager(
        val pref: SharedPref,
        val restaurantsRepo: RestaurantsRepo
)
