package tracker.feature.head

import android.app.Activity
import tracker.common.core.util.ServiceHelper
import tracker.common.presentation.SystemOverlayHelper

object AppHead {

    @JvmStatic
    fun show(activity: Activity) {
        if(!SystemOverlayHelper.checkDrawOverlayPermission(activity)) return
        ServiceHelper.start(AppHeadService::class.java)
    }

}