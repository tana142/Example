package com.example.tesschatapp.View.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tesschatapp.R
import android.view.WindowManager

class DetailMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_message)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}