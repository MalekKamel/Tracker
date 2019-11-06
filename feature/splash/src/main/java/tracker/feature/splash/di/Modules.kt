package tracker.feature.splash.di

import org.koin.core.context.loadKoinModules
import tracker.feature.splash.splashModule

internal fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(splashModule)
}
