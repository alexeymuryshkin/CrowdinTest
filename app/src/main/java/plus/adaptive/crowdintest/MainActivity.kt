package plus.adaptive.crowdintest

import android.os.Bundle
import android.widget.TextView
import com.crowdin.platform.Crowdin
import plus.adaptive.crowdintest.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)

        binding.titleTextView.text = getString(R.string.main_text)
//        val titleTextView = findViewById<TextView>(R.id.titleTextView)
//        titleTextView.text = getString(R.string.products_appbar_title)

        Crowdin.forceUpdate(this)
    }

}