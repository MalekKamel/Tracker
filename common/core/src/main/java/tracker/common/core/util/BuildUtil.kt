package tracker.common.core.util

import tracker.common.core.BuildConfig

object BuildUtil {

    enum class Type(name: String) {
        RELEASE("release"),
        DEBUG("debug")
    }

    fun isDebug() = BuildConfig.DEBUG

}
