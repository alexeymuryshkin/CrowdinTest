package plus.adaptive.crowdintest

import android.os.Bundle
import plus.adaptive.crowdintest.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //binding example
        binding.titleTextView.text = getString(R.string.main_text)

//        Crowdin.forceUpdate(this)
    }

}