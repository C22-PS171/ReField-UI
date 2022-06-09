package com.bangkit.myfield.detail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bangkit.myfield.R
import com.bangkit.myfield.databinding.ActivityListFutsalBinding
import com.bangkit.myfield.ui.home.HomeFragment

class ListFutsal : AppCompatActivity() {
    private lateinit var binding: ActivityListFutsalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFutsalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backHome : ImageView = binding.backImg
        backHome.setOnClickListener{
            val mFragmentManager = supportFragmentManager
            val mHomeFragment = HomeFragment()
            val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
            if (fragment !is HomeFragment) {
                Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
                mFragmentManager
                    .beginTransaction()
                    .add(R.id.container_futsal, mHomeFragment, HomeFragment::class.java.simpleName)
                    .commit()
            }
        }
        supportActionBar?.hide()
    }
}