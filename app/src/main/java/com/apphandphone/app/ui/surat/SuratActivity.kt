package com.apphandphone.app.ui.surat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apphandphone.app.R

class SuratActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surat)
    }

    companion object{
        const val OPEN_SURAT = "open_surat"
    }
}