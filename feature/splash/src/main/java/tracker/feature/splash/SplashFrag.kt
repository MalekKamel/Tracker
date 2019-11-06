package tracker.feature.splash

import android.os.Handler
import com.sha.kamel.navigator.modular.FragmentModuleNavigator
import org.koin.android.viewmodel.ext.android.viewModel
import restaurants.feature.splash.R
import tracker.common.presentation.frag.BaseFrag
import tracker.common.presentation.navigation.Fragments

class SplashFrag : BaseFrag<SplashVm>() {

    override var layoutId: Int = R.layout.frag_splash

    override val vm: SplashVm by viewModel()

    companion object {
        fun newInstance(): SplashFrag {
            return SplashFrag()
        }
    }

    override fun doOnViewCreated() {
        Handler().postDelayed( {
            activity?.apply {
                FragmentModuleNavigator(this)
                        .replace(Fragments.MapFrag, false)
            }
        }, 2000)
    }

}
