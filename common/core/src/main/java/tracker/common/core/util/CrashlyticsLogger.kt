package tracker.common.core.util


object CrashlyticsLogger {

    fun log(throwable: Throwable) {
        // In production we must uncomment
//        Crashlytics.getInstance().core.logException(throwable)
    }

    fun logThrowable(error: String?) {
        // In production we must uncomment
//        Crashlytics.getInstance().core.logException(Throwable(error))
    }

    fun logAndPrint(throwable: Throwable) {
        // In production we must uncomment
        throwable.printStackTrace()
//        Crashlytics.getInstance().core.logException(throwable)
    }

    fun logAndPrint(msg: String) {
        // In production we must uncomment
//        Crashlytics.getInstance().core.logException(Throwable(msg))
    }
}
