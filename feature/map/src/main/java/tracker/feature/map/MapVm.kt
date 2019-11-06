package tracker.feature.map

import android.location.Location
import androidx.fragment.app.FragmentActivity
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import com.sha.kamel.rxlocation.RxLocation
import io.reactivex.Flowable
import io.reactivex.Single
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent
import tracker.common.data.DataManager
import tracker.common.maps.commaSeparated
import tracker.common.maps.directions.RxDirectionsApi
import tracker.common.presentation.vm.BaseViewModel

val mapModule = module {
    viewModel { MapVm(get(), get()) }
    factory { RxLocation() }
    factory { RxDirectionsApi }
}

class MapVm(dataManager: DataManager,
            private val rxDirectionsApi: RxDirectionsApi
) : BaseViewModel(dataManager) {

    fun directions(activity: FragmentActivity): Flowable<DirectionsResult> {
        return  requester.request {
            currentLocation(activity)
                    .flatMap {
                        rxDirectionsApi.directions(
                                it.commaSeparated(),
                                Fake.destination,
                                TravelMode.DRIVING)
                    }.toFlowable()
        }
    }

    fun currentLocation(activity: FragmentActivity): Single<Location> {
        return KoinJavaComponent.get(RxLocation::class.java)
                .retrieveCurrentLocation(activity)
    }

}
