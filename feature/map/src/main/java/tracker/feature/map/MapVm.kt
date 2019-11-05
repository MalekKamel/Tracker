package tracker.feature.map

import android.location.Location
import androidx.fragment.app.FragmentActivity
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import com.sha.kamel.rxlocation.RxLocation
import com.sha.rxrequester.RequestOptions
import io.reactivex.Flowable
import io.reactivex.Single
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tracker.common.presentation.vm.BaseViewModel
import tracker.common.data.DataManager
import tracker.common.data.model.Restaurant
import tracker.common.core.util.disposeBy
import tracker.common.data.mapper.ListMapperImpl
import tracker.common.data.model.RestaurantMapper
import tracker.common.maps.RxDirectionsApi
import tracker.common.maps.commaSeparated

val mapModule = module {
    viewModel { MapVm(get()) }
}

class MapVm(dataManager: DataManager) : BaseViewModel(dataManager) {

    fun restaurants(callback: (List<Restaurant>) -> Unit) {
        val requestOptions = RequestOptions.Builder()
                .showLoading(true)
                .inlineErrorHandling { false }
                .build()
        requester.request(requestOptions) { dm.restaurantsRepo.all() }
                .subscribe {
                    val list =  ListMapperImpl(RestaurantMapper()).map(it.restaurants)
                    callback(list)
                }.disposeBy(disposable = disposables)
    }

    fun directions(activity: FragmentActivity): Flowable<DirectionsResult> {
        return  requester.request {
            currentLocation(activity)
                    .flatMap {
                        RxDirectionsApi.directions(
                                it.commaSeparated(),
                                Fake.destination,
                                TravelMode.DRIVING)
                    }.toFlowable()
        }
    }

    fun currentLocation(activity: FragmentActivity): Single<Location> {
        return  RxLocation()
                .retrieveCurrentLocation(activity)
    }

}
