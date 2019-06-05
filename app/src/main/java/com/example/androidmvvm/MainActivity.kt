package com.example.androidmvvm

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import com.example.androidmvvm.databinding.ActivityMainBinding

import com.example.androidmvvm.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMainBinding>(
                this, R.layout.activity_main)
        binding.lifecycleOwner = this


        val counterViewModel = ViewModelProviders.of(this)
                .get<CounterViewModel>(CounterViewModel::class.java)
        binding.counterViewModel = counterViewModel

    }
}
