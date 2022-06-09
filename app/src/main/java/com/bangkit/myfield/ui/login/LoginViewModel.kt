package com.bangkit.myfield.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "login your account \n for the get your field"
    }
    val text: LiveData<String> = _text
}