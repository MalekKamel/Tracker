package tracker.common.presentation.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tracker.common.core.util.CrashlyticsLogger
import tracker.common.presentation.BaseView

abstract class BaseActivity
    : AppCompatActivity(), BaseView {

    abstract var layoutId: Int

    protected open fun doOnCreate() {}
    protected open fun doOnCreate(savedInstanceState: Bundle?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            if (layoutId != 0)
                setContentView(layoutId)

            doOnCreate()
            doOnCreate(savedInstanceState)

        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }

    }

    override fun context(): Context {
        return this
    }

    override fun activity(): BaseActivity {
        return this
    }

}
