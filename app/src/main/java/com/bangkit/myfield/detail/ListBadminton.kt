package com.bangkit.myfield.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.myfield.R

class ListBadminton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_badminton)

        supportActionBar?.hide()
    }
}