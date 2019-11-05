package tracker.common.data.di

import android.preference.PreferenceManager
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import tracker.common.data.BuildConfig
import tracker.common.data.DataManager
import tracker.common.data.network.api.ApiInterface
import tracker.common.data.network.interceptor.TokenInterceptor
import tracker.common.data.pref.SharedPref
import tracker.common.data.restaurant.RestaurantDataSrc
import tracker.common.data.restaurant.RestaurantsRepo
import tracker.common.data.rx.SchedulerProvider
import tracker.common.data.rx.SchedulerProviderImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun injectPresentationModule() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
            presentationModule
    )
}

val presentationModule = module {
    factory { RestaurantsRepo(get()) }
    factory { RestaurantDataSrc(get()) }

    single { DataManager(get(), get()) }
    single { TokenInterceptor(get()) }
    single { SharedPref(get()) }
    single<SchedulerProvider> { SchedulerProviderImpl() }

    // default pref
    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }

    // OkHttpClient
    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val builder = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(get<TokenInterceptor>())
        builder.build()
    }

    // ApiInterface
    single {

        Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
                .create(ApiInterface::class.java)
    }

}