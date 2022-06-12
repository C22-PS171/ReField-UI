package com.bangkit.myfield.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bangkit.myfield.api.ApiService
import com.bangkit.myfield.responses.LoginResponse
import com.bangkit.myfield.responses.SignUpResponse

class Repository (private val apiService: ApiService) {
    fun postSignUp(
        name: String,
        email: String,
        password: String
    ):LiveData<Result<SignUpResponse>> = liveData { emit(Result.Loading)
    try {
        val response = apiService.postSignUp(name, email, password)
        emit(Result.Success(response))
    }catch (e: Exception){
        Log.d("Register", e.message.toString())
        emit(Result.Error(e.message.toString()))
    }
    }

    fun postLogin(email: String, password: String): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.postLogin(email, password)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Login", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
}