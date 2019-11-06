package tracker.common.maps

import com.google.maps.model.DirectionsResult
import tracker.common.core.util.StringBuilderUtil

object MapRouteHelper {

    fun timeAndDistanceDescription(result: DirectionsResult, overview: Int = 0): String {
        return StringBuilderUtil()
                .appendRes(R.string.time)
                .colon()
                .append(result.routes[overview].legs[overview].duration.humanReadable)
                .comma()
                .space()
                .appendRes(R.string.distance)
                .colon()
                .append(result.routes[overview].legs[overview].distance.humanReadable)
                .toString()
    }
}