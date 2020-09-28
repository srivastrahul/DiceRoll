package `in`.rahul.diceroll

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import java.util.*

class MainActivityViewModel : ViewModel(), Observable {

    val diceNumberMLD: MutableLiveData<Int> = MutableLiveData()
    val isRolling: MutableLiveData<Boolean> = MutableLiveData()

    private var lastClickTime: Long = System.nanoTime()
    private var currentClickTime: Long = 0L

    init {
        diceNumberMLD.value = R.drawable.six
        isRolling.value = false
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }




    fun setCurrentClickTime() {
        isRolling.value = true
        if (currentClickTime > 0L)
            lastClickTime = currentClickTime
        currentClickTime = System.nanoTime()
        calculateNumber()
    }

    private fun calculateNumber() {
        val n: Int = ((currentClickTime - lastClickTime) % 7L).toInt()
        if (n == 0)
            setCurrentClickTime()
        else {
            isRolling.value = false
            when (n) {
                1 -> diceNumberMLD.value = R.drawable.one
                2 -> diceNumberMLD.value = R.drawable.two
                3 -> diceNumberMLD.value = R.drawable.three
                4 -> diceNumberMLD.value = R.drawable.four
                5 -> diceNumberMLD.value = R.drawable.five
                6 -> diceNumberMLD.value = R.drawable.six
            }
        }
    }

}