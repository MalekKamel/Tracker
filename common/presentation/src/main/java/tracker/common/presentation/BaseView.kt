package tracker.common.presentation

import android.content.Context
import android.widget.Toast
import tracker.common.core.util.FlashBarHelper
import tracker.common.core.util.ThreadUtil
import tracker.common.presentation.activity.BaseActivity
import tracker.common.presentation.dialog.LoadingDialog
import tracker.common.presentation.dialog.LoadingDialogHelper
import tracker.common.presentation.dialog.RetryDialogFrag
import tracker.common.presentation.dialog.info.InfoDialog
import tracker.common.presentation.frag.BaseDialogFrag
import tracker.common.presentation.frag.BaseFrag

interface BaseView {

    fun activity(): BaseActivity?

    fun context(): Context? {
        return activity()
    }

    fun showRetryDialog(retryCallback: () -> Unit, closeCallback: () -> Unit) {
        ThreadUtil.runOnUiThread {
            RetryDialogFrag.newInstance(
                    retryCallback,
                    closeCallback).show(activity()!!)
        }
    }

    fun showRetryDialog(message: String, retryCallback: () -> Unit, closeCallback: () -> Unit) {
        ThreadUtil.runOnUiThread {
            RetryDialogFrag.newInstance(
                    message,
                    retryCallback,
                    closeCallback).show(activity()!!)
        }
    }

    fun showLoading() {
        ThreadUtil.runOnUiThread {

            if (activity() == null) return@runOnUiThread

            hideLoading()

            val dialog = LoadingDialog.newInstance()

            dialog.show(activity()!!)

            LoadingDialogHelper.add(dialog)
        }
    }

    fun showWarningDialog(msgRes: Int) {
        showWarningDialog(context()?.getString(msgRes))
    }

    fun showErrorDialog(errorRes: Int) {
        showErrorDialog(context()?.getString(errorRes))
    }

    fun showMessageDialog(msg: String?) {
        showMessageDialog(msg, null)
    }

    fun showMessageDialog(msg: String?, closeCallback: (() -> Unit)?) {
        showInfoDialog(type = InfoDialog.MessageType.INFO, msg = msg)
    }

    fun showMessageDialog(msgRes: Int) {
        showMessageDialog(context()?.getString(msgRes))
    }

    fun showMessageDialog(msgRes: Int, closeCallback: (() -> Unit)?) {
        showMessageDialog(context()?.getString(msgRes), closeCallback)
    }

    fun showErrorDialog(error: String?) {
        showInfoDialog(type = InfoDialog.MessageType.EXCEPTION, msg = error)
    }

    private fun showInfoDialog(msg: String?, type: InfoDialog.MessageType) {
        ThreadUtil.runOnUiThread {

            if (msg == null) return@runOnUiThread

            val infoDialog = InfoDialog.newInstance(
                    type,
                    msg,
                    false,
                    null
            )

            infoDialog.show(activity()!!)
        }
    }

    fun showWarningDialog(msg: String?) {
        showInfoDialog(type = InfoDialog.MessageType.WARNING, msg = msg)
    }

    fun hideLoading() {
        LoadingDialogHelper.hide()
    }

    fun fragment(): BaseFrag<*> {
        throw UnsupportedOperationException()
    }

    fun dialogFragment(): BaseDialogFrag {
        throw UnsupportedOperationException()
    }

    fun toast(resId: Int) {
        Toast.makeText(context(), resId, Toast.LENGTH_LONG).show()
    }

    fun showErrorInFlashBar(msg: String) {
        showMessageInFlashBar(StatusItem(StatusItem.ERROR, msg))
    }

    fun showErrorInFlashBar(msgRes: Int) {
        showErrorInFlashBar(context()!!.getString(msgRes))
    }

    fun showMessageInFlashBar(status: StatusItem) {
        ThreadUtil.runOnUiThread {
            if (activity() == null) return@runOnUiThread

            FlashBarHelper.show(
                    status.statusMessage,
                    status.getStatusColor(),
                    activity()!!
            )
        }
    }

    fun showSuccessInFlashBar(msg: String) {
        showMessageInFlashBar(StatusItem(StatusItem.SUCCESS, msg))
    }

    fun showSuccessInFlashBar(msgRes: Int) {
        showSuccessInFlashBar(context()!!.getString(msgRes))
    }

}
