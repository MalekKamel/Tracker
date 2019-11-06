package tracker.feature.map


import android.content.Context
import com.sha.rxrequester.RxRequester
import com.sha.rxrequester.TestSchedulerProvider
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.test.AutoCloseKoinTest
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import tracker.common.data.di.presentationModule
import tracker.common.data.pref.SharedPref


open class BaseUnitTest: AutoCloseKoinTest() {

    @Before
    fun setupCommon() {
        startKoin {
            modules(listOf(presentationModule))
            androidContext(Mockito.mock(Context::class.java))
            printLogger(Level.DEBUG)
            declareMock<SharedPref>()
        }
        RxRequester.defaultSchedulerProvider = TestSchedulerProvider
    }

}
