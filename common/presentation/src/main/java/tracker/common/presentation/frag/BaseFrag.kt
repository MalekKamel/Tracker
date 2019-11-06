package tracker.common.presentation.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import tracker.common.presentation.R
import tracker.common.presentation.activity.BaseActivity
import tracker.common.presentation.BaseView
import tracker.common.presentation.vm.BaseViewModel
import tracker.common.core.util.CrashlyticsLogger

abstract class BaseFrag<VM: BaseViewModel> : Fragment(), BaseView {

    abstract val vm: VM

    abstract var layoutId: Int
    open var swipeRefreshLayoutId: Int = 0
    protected open fun doOnViewCreated() {}
    protected fun doOnResume() {}

    open var hasBackNavigation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            vm.view = this

        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            doOnViewCreated()
            setupSwipeRefresh()
            enableBackNavigation()
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }

    }

    private fun setupSwipeRefresh() {
        val swipe = activity?.findViewById<SwipeRefreshLayout>(swipeRefreshLayoutId)
        if (swipeRefreshLayoutId != 0) {
            swipe?.setOnRefreshListener { this.onSwipeRefresh() }
        }
        else {
            swipe?.isEnabled = false
        }
    }

    /**
     * Designed to be overridden in Fragments that implement [HasSwipeRefresh]
     */
    protected open fun onSwipeRefresh() {}


    override fun onResume() {
        super.onResume()
        try {
            doOnResume()
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }
    }

    override fun activity(): BaseActivity? {
        return activity as? BaseActivity
    }

    override fun fragment(): BaseFrag<*> {
        return this
    }

    override fun baseViewModel(): BaseViewModel? {
        return vm
    }

    private fun enableBackNavigation() {
        if (!hasBackNavigation || view == null) return

        val backButton: View = view!!.findViewById(R.id.btnBack)
                ?: throw IllegalStateException("back button not found!")

        backButton.visibility = View.VISIBLE
        backButton.setOnClickListener { activity()?.onBackPressed() }
    }

    fun <T : View> findViewById(@IdRes id: Int): T {
        return activity!!.findViewById(id)
    }
}