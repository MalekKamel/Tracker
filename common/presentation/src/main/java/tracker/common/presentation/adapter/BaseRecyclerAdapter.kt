package tracker.common.presentation.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tracker.common.presentation.frag.BaseDialogFrag
import tracker.common.presentation.BaseView
import tracker.common.core.util.CrashlyticsLogger

/**
 * Created by Sha on 4/20/17.
 */

abstract class BaseRecyclerAdapter<M, VH
: BaseViewHolder<M>>(
        var list: List<M>,
        var baseView: BaseView
) : androidx.recyclerview.widget.RecyclerView.Adapter<VH>(){

    protected var isLoadingAdded: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent, viewType)
    }

    abstract fun getViewHolder(viewGroup: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        try {
            val item = list[position]
            holder.item = item
            holder.bindView(item)
        } catch (e: Exception) {
            CrashlyticsLogger.logAndPrint(e)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun item(position: Int): M {
        return list[position]
    }

    protected fun fragment(): Fragment {
        return baseView.fragment()
    }

    protected fun dialogFragment(): BaseDialogFrag<*> {
        return baseView.dialogFragment()
    }

    fun list(): List<M> {
        return list
    }

}
