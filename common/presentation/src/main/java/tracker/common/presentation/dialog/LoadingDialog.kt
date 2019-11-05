package tracker.common.presentation.dialog

import tracker.common.presentation.R
import tracker.common.presentation.frag.BaseDialogFrag
import tracker.common.presentation.vm.BaseViewModel
import tracker.common.core.util.ThreadUtil
import tracker.common.data.DataManager

class LoadingDialog(var isCancellable: Boolean = false) : BaseDialogFrag<LoadingVm>() {

     override var layoutId: Int = R.layout.frag_dialog_loading

    companion object {
        fun newInstance(isCancellable: Boolean = false): LoadingDialog {
            return LoadingDialog(isCancellable)
        }
    }

}

class LoadingVm(dataManager: DataManager) : BaseViewModel(dataManager)

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
