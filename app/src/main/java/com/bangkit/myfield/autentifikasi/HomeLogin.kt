package com.bangkit.myfield.autentifikasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bangkit.myfield.R
import com.bangkit.myfield.ui.login.LoginFragment

class HomeLogin : AppCompatActivity() {
    private lateinit var clearButton: ImageView
    private lateinit var moveRegister: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        moveRegister = findViewById(R.id.tv_register)
        moveRegister.setOnClickListener {
            val intent = Intent(this@HomeLogin, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        clearButton = findViewById(R.id.clear_button)
        clearButton.setOnClickListener {
            val mCategoryFragment = LoginFragment()
            val mFragmentManager = supportFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.container_login, mCategoryFragment, LoginFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        supportActionBar?.hide()
    }
}