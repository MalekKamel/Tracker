package tracker.feature.map

import android.location.Location
import androidx.fragment.app.FragmentActivity
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.sha.kamel.rxlocation.RxLocation
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.any
import tracker.common.maps.directions.RxDirectionsApi


class SearchVmTest : BaseUnitTest() {

    private val vm: MapVm by inject()

    @Mock
    lateinit var activity: FragmentActivity

    private lateinit var fakeDirectionsResult: FakeDirectionsResult
    private lateinit var location: Location

    @Before
    fun setup() {
        loadKoinModules(listOf(mapModule))
        fakeDirectionsResult = mock()

        location = mock()
        given(location.latitude).will { 1.0 }
        given(location.longitude).will { 2.0 }

        declareMock<RxLocation> {
            given(this.retrieveCurrentLocation(any())).will { Single.just(location) }
        }
        declareMock<RxDirectionsApi> {
            given(this.directions("1.0,2.0", Fake.destination, TravelMode.DRIVING))
                    .will { Single.just(fakeDirectionsResult) }
        }

        activity = mock()
    }

    @Test
    fun directions_shouldSucceed() {
       vm.directions(activity)
               .test()
               .assertNoErrors()
               .assertValueAt(0, fakeDirectionsResult)
               .assertValueCount(1)
    }

    @Test
    fun currentLocation_shouldSucceed() {
        vm.currentLocation(activity)
                .test()
                .assertNoErrors()
                .assertValueAt(0, location)
                .assertValueCount(1)
    }

}

class FakeDirectionsResult: DirectionsResult()