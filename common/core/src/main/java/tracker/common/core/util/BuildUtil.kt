package tracker.common.core.util

import tracker.common.core.BuildConfig

/**
 * Created by Sha on 11/20/17.
 */

class BuildUtil {

    enum class Type(name: String) {
        RELEASE("release"),
        DEBUG("debug")
    }

    companion object {
        fun isDebug() = BuildConfig.DEBUG
    }

}
