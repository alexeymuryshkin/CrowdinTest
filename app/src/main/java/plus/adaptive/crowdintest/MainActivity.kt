package plus.adaptive.crowdintest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.BaseContextWrappingDelegate
import com.crowdin.platform.Crowdin
import plus.adaptive.crowdintest.databinding.ActivityMainBinding
import java.util.*


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locale = Locale("ru", "RU")
        Locale.setDefault(locale)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //binding example
        binding.titleTextView.text = getString(R.string.main_text)

        //access via Id example
        findViewById<TextView>(R.id.titleTextView).text = getString(R.string.main_text)
    }

}