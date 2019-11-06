package tracker.common.presentation.dialog

import tracker.common.core.util.ThreadUtil
import tracker.common.presentation.R
import tracker.common.presentation.frag.BaseDialogFrag

class LoadingDialog(var isCancellable: Boolean = false) : BaseDialogFrag() {

     override var layoutId: Int = R.layout.frag_dialog_loading

    companion object {
        fun newInstance(isCancellable: Boolean = false): LoadingDialog {
            return LoadingDialog(isCancellable)
        }
    }
}

object LoadingDialogHelper {
    var instances: MutableList<LoadingDialog?> = mutableListOf()

    fun add(dialog: LoadingDialog){
        ThreadUtil.runOnUiThread {
            instances.forEach {
                it?.dismiss()
            }
            instances.clear()
            instances.add(dialog)
        }
    }

    fun hide() {
        ThreadUtil.runOnUiThread {
            instances.forEach { it?.dismiss() }
        }
    }

}
