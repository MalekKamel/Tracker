package tracker.common.maps

import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.Api
import com.google.android.gms.common.api.GoogleApiClient
import tracker.common.core.CoreApp
import tracker.common.core.util.CrashlyticsLogger

object GoogleApiClientConnector {
    private var client: GoogleApiClient? = null

    fun connect(
            apis: List<Api<out Api.ApiOptions.NotRequiredOptions>>,
            connectedCallback: (GoogleApiClient?) -> Unit
    ): GoogleApiClient {

        val connectionCallback = object : GoogleApiClient.ConnectionCallbacks {
            override fun onConnected(bundle: Bundle?) {
                connectedCallback(client)
            }

            override fun onConnectionSuspended(i: Int) {}
        }

        val builder = GoogleApiClient.Builder(CoreApp.context)
                .addConnectionCallbacks(connectionCallback)
                .addOnConnectionFailedListener { connectionResult ->
                    Log.e("GoogleApiClientUtil", "connectionResult = " + connectionResult.errorMessage!!)
                    CrashlyticsLogger.logThrowable(connectionResult.errorMessage)
                }

        for (api in apis) builder.addApi(api)

        val googleApiClient = builder.build()
        googleApiClient.connect()
        return googleApiClient
    }

}
