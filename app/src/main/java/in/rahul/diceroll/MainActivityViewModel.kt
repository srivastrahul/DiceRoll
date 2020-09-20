package `in`.rahul.diceroll

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel : ViewModel(), Observable {


    @Bindable
    val diceNumberMLD = MutableLiveData<String>()

    private var lastClickTime : Long = System.nanoTime()
    private  var currentClickTime: Long = 0L


    init {
        diceNumberMLD.value = "1"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    fun setCurrentClickTime() {
        if (currentClickTime > 0L)
            lastClickTime = currentClickTime
        currentClickTime = System.nanoTime()
        calculateNumber()
    }

    private fun calculateNumber() {
        val n: Int = ((currentClickTime - lastClickTime) % 7L).toInt()
        if (n == 0)
            setCurrentClickTime()
        else
            diceNumberMLD.value = n.toString()
    }

}