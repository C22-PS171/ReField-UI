package com.bangkit.myfield.di

import android.content.Context
import com.bangkit.myfield.api.ApiConfig
import com.bangkit.myfield.repository.Repository

object Injection {
    fun provideRepository(context: Context): Repository{
        val apiService =ApiConfig.getApiService()
        return Repository(apiService)
    }
}