package tracker.feature.splash

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tracker.common.presentation.vm.BaseViewModel
import tracker.common.data.DataManager

/**
 * Created by Sha on 9/15/17.
 */

val splashModule = module {
    viewModel { SplashVm(get()) }
}

class SplashVm(dataManager: DataManager) : BaseViewModel(dataManager)