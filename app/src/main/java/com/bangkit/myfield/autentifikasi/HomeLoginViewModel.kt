package com.bangkit.myfield.autentifikasi

import androidx.lifecycle.ViewModel
import com.bangkit.myfield.repository.Repository

class HomeLoginViewModel(private val repository: Repository): ViewModel() {
    fun postLogin(email: String, password: String) = repository.postLogin(email, password)
}