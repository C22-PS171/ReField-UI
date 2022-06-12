package com.bangkit.myfield.autentifikasi

import androidx.lifecycle.ViewModel
import com.bangkit.myfield.repository.Repository

class RegisterViewModel (private val repository: Repository) : ViewModel(){
    fun postSignUp(name: String, email: String, password: String) =
        repository.postSignUp(name, email, password)
}