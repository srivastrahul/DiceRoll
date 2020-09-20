package `in`.rahul.diceroll

import `in`.rahul.diceroll.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.activityViewModel = activityViewModel
        binding.lifecycleOwner = this
    }
}