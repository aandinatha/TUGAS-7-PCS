package com.apphandphone.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.apphandphone.app.R
import com.apphandphone.app.databinding.ActivityMainBinding
import com.apphandphone.app.ui.auth.ApphandphoneAuth
import com.apphandphone.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            ApphandphoneAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}