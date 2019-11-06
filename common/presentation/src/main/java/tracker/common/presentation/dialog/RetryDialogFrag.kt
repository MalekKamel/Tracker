package tracker.common.presentation.dialog

import kotlinx.android.synthetic.main.frag_dialog_retry.*
import tracker.common.presentation.R
import tracker.common.presentation.frag.BaseDialogFrag

class RetryDialogFrag : BaseDialogFrag() {

    private var retryCallback: (() -> Unit)? = null
    private var closeCallback: (() -> Unit)? = null
    private var message: String? = null

    override var layoutId: Int = R.layout.frag_dialog_retry

    override fun doOnViewCreated() {
        if (message != null)
            tv_message.text = message
    }

    override fun setupUi() {
        btn_retry.setOnClickListener {
            if (retryCallback != null)
                retryCallback!!.invoke()
            dismiss()
        }

        btn_close.setOnClickListener {
            if (closeCallback != null)
                closeCallback!!.invoke()
            dismiss()
        }
    }

    companion object {

        fun newInstance(retryCallback: () -> Unit, closeCallback: () -> Unit): RetryDialogFrag {
            return RetryDialogFrag().apply {
                this.retryCallback = retryCallback
                this.closeCallback = closeCallback
            }
        }

        fun newInstance(message: String, retryCallback: () -> Unit, closeCallback: () -> Unit): RetryDialogFrag {
            return RetryDialogFrag().apply {
                this.message = message
                this.retryCallback = retryCallback
                this.closeCallback = closeCallback
            }
        }
    }
}


