package com.bangkit.myfield.api

import com.bangkit.myfield.responses.LoginRequest
import com.bangkit.myfield.responses.LoginResponse
import com.bangkit.myfield.responses.SignUpRequest
import com.bangkit.myfield.responses.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/refield/login")
    fun userLogin(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("/refield/signup")
    fun userSignUp(
        @Body signUpRequest: SignUpRequest
    ): SignUpResponse
}