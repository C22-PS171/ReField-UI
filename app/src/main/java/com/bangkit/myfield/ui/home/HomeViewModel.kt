package com.bangkit.myfield.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val kalender: Calendar = Calendar.getInstance()
        val jam : Int = kalender.get(Calendar.HOUR_OF_DAY)
        value = if (jam in 0..11){
            "Good Morning \n People"
        }else if (jam in 12..15){
            "Good Aftenoon \n People"
        }else if (jam in 16..20){
            "good Evening \n People"
        }else if (jam in 21..23){
            "Good Night \n People"
        }else {
            "What's Up Bro"
        }
    }
    val text: LiveData<String> = _text
}