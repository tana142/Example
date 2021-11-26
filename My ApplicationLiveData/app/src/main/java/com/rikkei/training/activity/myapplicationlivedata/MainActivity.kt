package com.rikkei.training.activity.myapplicationlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rikkei.training.activity.myapplicationlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var viewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = UserViewModel()
        viewModel?.liveData?.observe(this) {
            binding?.tt?.text = it.name
        }
//duc  say hello
        binding?.btnClick?.setOnClickListener {
            viewModel?.clickButton()
        }
    }
}