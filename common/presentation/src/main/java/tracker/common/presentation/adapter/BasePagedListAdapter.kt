package tracker.common.presentation.adapter

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import tracker.common.presentation.BaseView
import tracker.common.core.util.CrashlyticsLogger


abstract class BasePagedListAdapter<T> constructor(protected var view: BaseView, diffCallback: DiffUtil.ItemCallback<T>)
    : PagedListAdapter<T, BaseViewHolder<T>>(diffCallback) {


    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        try {
            val item = getItem(position)
            if( item != null) holder.bindView(item)
        } catch (e: Exception) {
            e.printStackTrace()
            CrashlyticsLogger.log(e)
        }

    }


}
