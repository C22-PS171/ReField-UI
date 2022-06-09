package com.bangkit.myfield.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val kalender: Calendar = Calendar.getInstance()
        val jam : Int = kalender.get(Calendar.HOUR_OF_DAY)
        if (jam >= 0 && jam < 12 ){
            value = "Good Morning \n People"
        }else if (jam >= 12 && jam < 16){
            value = "Good Aftenoon \n People"
        }else if (jam >= 16 && jam < 21){
            value = "good Evening"
        }else if (jam >= 21 && jam < 24){
            value = "Good Night \n People"
        }else {
            value = "What's Up Bro"
        }
    }
    val text: LiveData<String> = _text
}