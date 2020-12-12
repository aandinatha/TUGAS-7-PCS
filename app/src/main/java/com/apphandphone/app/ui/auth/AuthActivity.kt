package com.apphandphone.app.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.apphandphone.app.R
import com.apphandphone.app.data.model.AuthUser
import com.apphandphone.app.databinding.ActivityAuthBinding
import com.apphandphone.app.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user: AuthUser?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}