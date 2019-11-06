package tracker.common.core.util

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object PermissionHelper {

    fun isAnyGranted(permissions: Set<String>, activity: Activity): Boolean {
     return permissions.any { isGranted(it, activity) }
    }
    fun isAllGranted(permissions: Set<String>, activity: Activity): Boolean {
     return permissions.all { isGranted(it, activity) }
    }

    fun isGranted(permission: String, activity: Activity): Boolean {
        return ContextCompat.checkSelfPermission(activity, permission) ==
                PackageManager.PERMISSION_GRANTED
    }

}