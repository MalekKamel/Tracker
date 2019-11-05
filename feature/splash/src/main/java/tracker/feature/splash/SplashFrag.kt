package tracker.feature.splash

import android.os.Handler
import org.koin.android.viewmodel.ext.android.viewModel
import restaurants.feature.splash.R
import tracker.common.presentation.frag.BaseFrag

class SplashFrag : BaseFrag<SplashVm>() {

    override var layoutId: Int = R.layout.frag_splash

    override val vm: SplashVm by viewModel()

    override fun doOnViewCreated() {
        Handler().postDelayed( {
//            FragmentNavigator(activity as FragmentActivity)
//                    .add(fragmentFrom(Fragments.Restaurants),
//                            false)
        }, 2000)
    }

}
