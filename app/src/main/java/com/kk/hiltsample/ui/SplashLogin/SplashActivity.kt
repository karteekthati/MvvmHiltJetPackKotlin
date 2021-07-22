package com.kk.hiltsample.ui.SplashLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kk.hiltsample.R
import com.kk.hiltsample.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private var _binding : ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       _binding = ActivitySplashBinding.inflate(layoutInflater)
       setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)

    }
}