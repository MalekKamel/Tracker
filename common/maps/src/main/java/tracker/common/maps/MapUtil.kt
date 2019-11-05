package tracker.common.maps

import android.content.Context
import android.content.Intent
import android.net.Uri

import com.google.android.gms.maps.model.LatLng
import tracker.common.core.util.StringBuilderUtil


/**
 * Created by Sha on 1/7/18.
 */

object MapUtil {

    fun openGoogleMapApp(context: Context, latLng: LatLng) {

        val url = StringBuilderUtil()
                .append("http://maps.google.com/maps?saddr=")
                .append(latLng.latitude)
                .append(",")
                .append(latLng.longitude)
                .append("&daddr=")
                .toString()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    fun showRoute(context: Context, lat: Double, lng: Double) {
        val url = StringBuilder()
                .append("http://maps.google.com/maps?")
                .append("daddr=")
                .append(lat)
                .append(",")
                .append(lng)
                .toString()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

}

