package `in`.rahul.diceroll

import `in`.rahul.diceroll.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

    override fun onPostResume() {
        super.onPostResume()

        activityViewModel.isRolling.observe(this, Observer { isDiceRolling ->
            if (isDiceRolling) {
                val animationListener = object : Animation.AnimationListener {


                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        binding.diceIV.setImageResource(activityViewModel.diceNumberMLD.value!!)
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }
                }
                val diceRoll: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
                diceRoll.setAnimationListener(animationListener)
                binding.diceIV.startAnimation(diceRoll)
            }
        })
    }
}