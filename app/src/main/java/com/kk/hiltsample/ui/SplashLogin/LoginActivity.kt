package com.kk.hiltsample.ui.SplashLogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.kk.hiltsample.R
import com.kk.hiltsample.databinding.ActivityLoginBinding
import com.kk.hiltsample.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intiViews()
    }

    private fun intiViews() {
//        binding.btnLogin.setOnClickListener {
//            viewModel.login()
//        }

    }


}

