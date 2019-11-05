package tracker.common.core

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.StringRes

open class CoreApp: Application() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @JvmStatic
        fun string(@StringRes res: Int): String {
            return context.getString(res)
        }

    }

}