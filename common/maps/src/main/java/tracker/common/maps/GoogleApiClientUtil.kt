package tracker.common.maps

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.Api
import com.google.android.gms.common.api.GoogleApiClient

/**
 * Created by Sha on 1/7/18.
 */

class GoogleApiClientUtil {
    private var client: GoogleApiClient? = null

    fun create(
            context: Context,
            connectedCallback: (GoogleApiClient?) -> Unit,
            vararg apis: Api<out Api.ApiOptions.NotRequiredOptions>
    ) {
        client = create(context,
                object : GoogleApiClient.ConnectionCallbacks {
            override fun onConnected(bundle: Bundle?) {
                connectedCallback.invoke(client)
            }

            override fun onConnectionSuspended(i: Int) {

            }
        },
                *apis)
    }

    companion object {

        fun create(
                context: Context,
                callbacks: GoogleApiClient.ConnectionCallbacks,
                vararg apis: Api<out Api.ApiOptions.NotRequiredOptions>
        ): GoogleApiClient {

            val builder = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(callbacks)
                    .addOnConnectionFailedListener { connectionResult ->
                        Log.e(
                                "GoogleApiClientUtil",
                                "connectionResult = " + connectionResult.errorMessage!!)
                    }

            if (apis.isNotEmpty())
                for (api in apis) builder.addApi(api)

            val googleApiClient = builder.build()
            googleApiClient.connect()
            return googleApiClient
        }
    }

}
