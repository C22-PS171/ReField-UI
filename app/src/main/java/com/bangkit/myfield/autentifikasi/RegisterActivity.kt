package com.bangkit.myfield.autentifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.myfield.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()
    }
}