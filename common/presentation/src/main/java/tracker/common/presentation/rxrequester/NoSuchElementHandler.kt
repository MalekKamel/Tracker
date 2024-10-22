package tracker.common.presentation.rxrequester

import com.sha.rxrequester.exception.handler.throwable.ThrowableHandler
import com.sha.rxrequester.exception.handler.throwable.ThrowableInfo
import tracker.common.presentation.R
import java.util.*

class NoSuchElementHandler : ThrowableHandler<NoSuchElementException>() {

    override fun supportedErrors(): List<Class<out NoSuchElementException>> {
        return listOf(NoSuchElementException::class.java)
    }

    override fun handle(info: ThrowableInfo) {
        info.presentable.showError(R.string.no_data_entered_yet)
    }
}
