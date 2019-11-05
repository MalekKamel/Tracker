package tracker.common.presentation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

/**
 * Created by Sha on 11/20/17.
 */

object SystemOverlayHelper {
    private const val OVERLAY_REQUEST_CODE = 251

    fun canDrawOverlays(activity: Activity): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.canDrawOverlays(activity)
    }

    fun checkDrawOverlayPermission(activity: Activity): Boolean {
        if (canDrawOverlays(activity)) return true

        val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + activity.packageName)
        )
        activity.startActivityForResult(intent, OVERLAY_REQUEST_CODE)
        return false
    }

}
