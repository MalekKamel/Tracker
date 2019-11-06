package tracker.common.presentation.dialog.info

import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.frag_dialog_info.*
import tracker.common.presentation.R
import tracker.common.presentation.frag.BaseDialogFrag

class InfoDialog : BaseDialogFrag() {

    private var messageType: MessageType? = null
    private var isCancellable: Boolean = false
    private var message: String? = null
    private var closeCallback: (() -> Unit)? = null

    enum class MessageType {
        INFO,
        WARNING,
        EXCEPTION
    }

    override var layoutId: Int = R.layout.frag_dialog_info

    override fun setupUi() {
        dialog?.setCanceledOnTouchOutside(isCancellable)

        tv_message!!.text = message

        var color = -1

        if (messageType != null)
            when (messageType) {

                MessageType.WARNING -> {
                    color = R.color.warning
                    tv_message!!.setTextColor(ContextCompat.getColor(context!!, R.color.warning))
                }

                MessageType.EXCEPTION -> color = R.color.exception

                else -> {}
            }

        if (color != -1)
            tv_message!!.setTextColor(ContextCompat.getColor(context!!, color))

        btn_close.setOnClickListener {
            if (closeCallback != null) closeCallback!!.invoke()
            dismiss()
        }
    }

    companion object {
        fun newInstance(
                type: MessageType,
                message: String,
                isCancellable: Boolean,
                closeCallback: (() -> Unit)?): InfoDialog {
            return InfoDialog().apply {
                this.messageType = type
                this.message = message
                this.isCancellable = isCancellable
                this.closeCallback = closeCallback
            }
        }
    }
}

