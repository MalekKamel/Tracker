package tracker.feature.map.di

import org.koin.core.context.loadKoinModules
import tracker.feature.map.mapModule

internal fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(mapModule)
}
