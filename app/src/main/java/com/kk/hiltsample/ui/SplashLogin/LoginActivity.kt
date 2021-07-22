package com.kk.hiltsample.ui.SplashLogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kk.hiltsample.R
import com.kk.hiltsample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var datastore: DataStore<Preferences>
    private var _binding: ActivityLoginBinding? = null
    private val  binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       _binding = ActivityLoginBinding.inflate(layoutInflater)
       setContentView(binding.root)
      // datastore = createDataStore()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}