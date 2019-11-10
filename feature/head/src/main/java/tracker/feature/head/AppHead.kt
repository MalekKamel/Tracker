package tracker.feature.head

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.sha.apphead.AppHead
import com.sha.apphead.BadgeView
import com.sha.apphead.Head
import com.sha.apphead.HeadView
import com.sha.kamel.navigator.modular.ActivityModuleNavigator
import restaurants.feature.head.R
import tracker.common.core.CoreApp
import tracker.common.presentation.navigation.Activities

object AppHead {

    @JvmStatic
    fun show(activity: FragmentActivity) {
        runCatching {
            val builder = Head.Builder(R.mipmap.ic_launcher)
                    .headView(HeadView.Args()
                            .onClick {
                                ActivityModuleNavigator(activity, activity.packageName)
                                        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        .navigate(Activities.Main)
                            }
                            .setupImage {
                                it.layoutParams.width = 200
                                it.layoutParams.height = 200
                            })
            AppHead(builder).show(activity)
        }.onFailure { it.printStackTrace() }
    }

    fun hide() {
        AppHead.hide(CoreApp.context)
    }

}