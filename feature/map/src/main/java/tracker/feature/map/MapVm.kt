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
import tracker.common.data.DataManager
import tracker.common.maps.RxDirectionsApi
import tracker.common.maps.commaSeparated
import tracker.common.presentation.vm.BaseViewModel

val mapModule = module {
    viewModel { MapVm(get()) }
}

class MapVm(dataManager: DataManager) : BaseViewModel(dataManager) {

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
