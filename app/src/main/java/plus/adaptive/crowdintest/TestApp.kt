package plus.adaptive.crowdintest

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.crowdin.platform.Crowdin
import com.crowdin.platform.CrowdinConfig
import com.crowdin.platform.LoadingStateListener
import com.crowdin.platform.data.remote.NetworkType
import java.util.*


class TestApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        val locale = Locale("ru", Locale.getDefault().country)
        Locale.setDefault(locale)

        // Crowdin
        Crowdin.init(
            applicationContext,
            CrowdinConfig.Builder()
                .withDistributionHash("f3ccf970872dbae9944db691c6m")
                .withNetworkType(NetworkType.ALL)
                .withUpdateInterval(900)
                .build()
        )
        Crowdin.registerDataLoadingObserver(object: LoadingStateListener {
            override fun onDataChanged() {
                Log.e("CrowdinSDK", "onDataChanged")
            }

            override fun onFailure(throwable: Throwable) {
                Log.e("CrowdinSDK", "onFailure")
            }

        })
    }

}