package tracker.common.presentation.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tracker.common.presentation.BaseView
import tracker.common.presentation.vm.BaseViewModel
import tracker.common.core.util.CrashlyticsUtil

abstract class BaseActivity
    : AppCompatActivity(), BaseView {

    abstract var layoutId: Int

    protected open fun bindUi() {}
    protected open fun doOnCreate() {}
    protected open fun doOnCreate(savedInstanceState: Bundle?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            if (layoutId != 0)
                setContentView(layoutId)

            bindUi()
            doOnCreate()
            doOnCreate(savedInstanceState)

        } catch (e: Exception) {
            CrashlyticsUtil.logAndPrint(e)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        try {

        } catch (e: Exception) {
            CrashlyticsUtil.logAndPrint(e)
        }

    }

    override fun context(): Context {
        return this
    }

    override fun activity(): BaseActivity {
        return this
    }

    override fun baseViewModel(): BaseViewModel? {
        return null
    }

}
