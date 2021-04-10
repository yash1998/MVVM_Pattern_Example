package com.example.mvvm_pattern_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_pattern_example.databinding.ActivityMainBinding
import com.example.mvvm_pattern_example.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewmodel: LoginViewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
        setEventListeners()
    }

    private fun setObservers() {
        viewmodel.loginStatus.observe(this, Observer { isSuccess ->
            if (isSuccess) {
                binding.textLoginStatus.text = "Login Success"
                binding.textLoginStatus.setTextColor(ContextCompat.getColor(this, R.color.green))
            } else {
                binding.textLoginStatus.text = "Login Error"
                binding.textLoginStatus.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        })
    }

    private fun setEventListeners() {
        binding.buttonLogin.setOnClickListener {
            viewmodel.startLogin(
                binding.editTextUsername.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }
    }
}
