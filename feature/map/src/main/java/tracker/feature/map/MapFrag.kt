package tracker.feature.map

import android.content.Intent
import android.os.Bundle
import com.google.maps.model.DirectionsResult
import com.sha.kamel.navigator.ActivityNavigator
import com.sha.kamel.navigator.MapRoute
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.frag_map.*
import org.koin.android.viewmodel.ext.android.viewModel
import restaurants.feature.restaurants.R
import tracker.common.core.util.disposeBy
import tracker.common.maps.GoogleMapSetup
import tracker.common.maps.MapRouteHelper
import tracker.common.maps.drawRoute
import tracker.common.presentation.SystemOverlayHelper
import tracker.common.presentation.ext.show
import tracker.common.presentation.frag.BaseFrag
import tracker.feature.head.AppHead
import tracker.feature.map.di.injectFeature


class MapFrag : BaseFrag<MapVm>() {

    override val vm: MapVm by viewModel()
    override var layoutId: Int = R.layout.frag_map
    private var mapSetup: GoogleMapSetup = GoogleMapSetup()

    companion object {
        fun newInstance(): MapFrag {
            return MapFrag()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectFeature()
        super.onCreate(savedInstanceState)
    }

    override fun doOnViewCreated() {
        super.doOnViewCreated()
        setupUi()
        setupMap()
    }

    private fun setupUi() {
        btnDirections.setOnClickListener {
            activity?.apply {
                vm.currentLocation(this)
                        .subscribe(Consumer {
                            val route = MapRoute(
                                    it.latitude,
                                    it.longitude,
                                    Fake.latLng().latitude,
                                    Fake.latLng().longitude
                            )
                            ActivityNavigator(this).showRouteInGoogleMap(route)

                            showAppHead()
                        })
                        .disposeBy(vm.disposables)

            }
        }
    }

    private fun showAppHead() {
        activity?.apply {
            if(!SystemOverlayHelper.checkDrawOverlayPermission(this)) return
            startService(Intent(this, AppHead::class.java))
        }
    }

    private fun setupMap() {
        mapSetup.setup(this, R.id.map)
        mapSetup.onMapReady = { loadRouteInfo() }
    }
    
    private fun loadRouteInfo() {
        activity?.apply {
            vm.directions(this)
                    .subscribe { showRouteInfo(it) }
                    .disposeBy(vm.disposables)
        }
    }

    private fun showRouteInfo(result: DirectionsResult) {
        if (result.routes.isNullOrEmpty()) {
            showErrorInFlashBar(R.string.no_route)
            return
        }

        mapSetup.map?.drawRoute(result)

        tvDistanceAndTime.apply {
            text = MapRouteHelper.timeAndDistanceDescription(result)
            show()
        }
    }

    override fun onStart() {
        super.onStart()
        mapSetup.connect()
    }

    override fun onStop() {
        super.onStop()
        mapSetup.disconnect()
    }

}
