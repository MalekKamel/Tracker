package tracker.feature.head

import android.content.Intent
import android.view.View
import com.sha.kamel.navigator.modular.ActivityModuleNavigator
import restaurants.feature.head.R
import tracker.common.presentation.navigation.Activities


class AppHeadService : AbstractHeadService() {

    override val layoutId: Int = R.layout.app_head

    override fun setupHeadView(head: AppHeadView) {
        head.findViewById<View>(R.id.btnDismiss).setOnClickListener { stopSelf() }

        head.onHeadClicked = {
            ActivityModuleNavigator(this, packageName)
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigate(Activities.Main)
            stopSelf()
        }

    }

}