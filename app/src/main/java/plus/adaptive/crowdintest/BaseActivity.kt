package plus.adaptive.crowdintest

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.BaseContextWrappingDelegate
import com.crowdin.platform.Crowdin
import java.util.*


open class BaseActivity : AppCompatActivity() {

//    override fun getDelegate() = BaseContextWrappingDelegate(super.getDelegate())

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            newBase?.let {
//                Crowdin.wrapContext(it)
                Crowdin.wrapContext(
                    it.localized("ru")
                )
            }
        )
    }

    private fun Context.localized(lang: String) : Context {
        val locale = Locale(lang, Locale.getDefault().country)
        Locale.setDefault(locale)

        val config = resources.configuration

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            config.setLayoutDirection(locale)

            createConfigurationContext(config)
        } else {
            config.locale = locale

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config.setLayoutDirection(locale)
            }

            resources.updateConfiguration(config, resources.displayMetrics)

            this
        }
    }

}