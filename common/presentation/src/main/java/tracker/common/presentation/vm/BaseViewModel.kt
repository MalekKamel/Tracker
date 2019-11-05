package tracker.common.presentation.vm

import androidx.lifecycle.ViewModel
import com.sha.rxrequester.Presentable
import com.sha.rxrequester.RxRequester
import io.reactivex.disposables.CompositeDisposable
import tracker.common.presentation.rx.ServerErrorHandler
import tracker.common.presentation.rx.IoExceptionHandler
import tracker.common.presentation.rx.NoSuchElementHandler
import tracker.common.presentation.rx.OutOfMemoryErrorHandler
import tracker.common.presentation.rx.ErrorContract
import tracker.common.presentation.BaseView
import tracker.common.presentation.R
import tracker.common.data.DataManager
import tracker.common.data.pref.SharedPref

open class BaseViewModel(val dm: DataManager)
    : ViewModel() {

    lateinit var view: BaseView
    var pref: SharedPref = dm.pref
    val disposables: CompositeDisposable = CompositeDisposable()
    var requester: RxRequester

    init {
        requester = setupRequester()
    }

    private fun setupRequester(): RxRequester {
        val presentable = object: Presentable {
            override fun showError(error: String) {
                view.showErrorInFlashBar(error)
            }

            override fun showError(error: Int) {
                view.showErrorInFlashBar(error)
            }

            override fun showLoading() {
                view.showLoading()
            }

            override fun hideLoading() {
                view.hideLoading()
            }

            override fun onHandleErrorFailed(throwable: Throwable) {
                view.showErrorInFlashBar(R.string.oops_something_went_wrong)
            }

        }

       val requester = RxRequester.create(ErrorContract::class.java, presentable)

        if (RxRequester.throwableHandlers.isEmpty())
            RxRequester.throwableHandlers = listOf(
                    IoExceptionHandler(),
                    NoSuchElementHandler(),
                    OutOfMemoryErrorHandler()
            )
        if (RxRequester.httpHandlers.isEmpty())
            RxRequester.httpHandlers = listOf(
                    ServerErrorHandler()
            )
        return requester
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}

