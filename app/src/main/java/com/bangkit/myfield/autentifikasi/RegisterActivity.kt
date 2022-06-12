package com.bangkit.myfield.autentifikasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bangkit.myfield.databinding.ActivityRegisterBinding
import com.bangkit.myfield.repository.Result

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val viewModelFactory: ViewModelFactory = ViewModelFactory.getInstance(this)
        val registerViewModel: RegisterViewModel by viewModels {
            viewModelFactory
        }

        binding.buttonRegister.setOnClickListener {
            registerViewModel.postSignUp(
                binding.userText.text.toString(),
                binding.emailText.text.toString(),
                binding.inputPass.text.toString()
            ).observe(this){ result ->
                when (result) {
                   is Result.Loading -> {
                       binding.progressBar.visibility = View.VISIBLE
                }
                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this,
                            "Register ${result.data.message}",
                            Toast.LENGTH_SHORT
                        ).show()

                        startActivity(Intent(this@RegisterActivity, HomeLogin::class.java))
                    }
                    is Result.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this,
                            "Register ${result.error}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }
    }
}