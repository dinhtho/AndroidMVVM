package com.example.androidmvvm

import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import com.example.androidmvvm.databinding.ActivityMainBinding

import com.example.androidmvvm.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMainBinding>(
                this, R.layout.activity_main)
        binding.lifecycleOwner = this


        val mainViewModel = ViewModelProviders.of(this)
                .get<MainActivityViewModel>(MainActivityViewModel::class.java)
        binding.mainViewModel = mainViewModel

        mainViewModel.userRetrofit.observe(this,
                Observer { user -> binding.tvNotUseDataBinding.text = user.name })

    }
}
