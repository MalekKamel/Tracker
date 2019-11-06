package tracker.feature.head

import android.app.Activity
import android.content.Intent
import tracker.common.presentation.SystemOverlayHelper

object AppHead {

    @JvmStatic
    fun show(activity: Activity) {
        if(!SystemOverlayHelper.checkDrawOverlayPermission(activity)) return
        activity.startService(Intent(activity, AppHeadService::class.java))
    }

}