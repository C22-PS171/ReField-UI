package com.bangkit.myfield.autentifikasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bangkit.myfield.R
import com.bangkit.myfield.databinding.ActivityHomeLoginBinding
import com.bangkit.myfield.model.User
import com.bangkit.myfield.model.UserPreferences
import com.bangkit.myfield.repository.Result
import com.bangkit.myfield.ui.home.HomeFragment
import com.bangkit.myfield.ui.login.LoginFragment

class HomeLogin : AppCompatActivity() {
    private lateinit var clearButton: ImageView
    private lateinit var moveRegister: TextView
    private lateinit var binding: ActivityHomeLoginBinding
    private var userModel: User = User()
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        userPreferences = UserPreferences(this)

        val viewModelFactory: ViewModelFactory = ViewModelFactory.getInstance(this)
        val homeLoginViewModel: HomeLoginViewModel by viewModels {
            viewModelFactory
        }
        binding.loginButton.setOnClickListener{
            homeLoginViewModel.postLogin(
                binding.emailText.text.toString(),
                binding.inputPass.text.toString()
            ).observe(this){ result ->
                if (result != null){
                    when(result){
                        is Result.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is Result.Success -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                this,
                                "Login ${result.data.message}",
                                Toast.LENGTH_SHORT
                            ).show()

                            val response = result.data
                            saveToken(response.loginResult!!.token)

                            val intent = Intent(this@HomeLogin, HomeFragment::class.java)
                            intent.putExtra(EXTRA_KEY, response.loginResult.token)
                            startActivity(intent)
                        }
                        is Result.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, "Login ${result.error}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun saveToken(token: String) {
        userModel.token = token
        userPreferences.setUsers(userModel)

    }

    companion object {
        const val EXTRA_KEY = "extra_key"
    }
}