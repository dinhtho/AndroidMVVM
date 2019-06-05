package com.example.androidmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.androidmvvm.model.Count

/**
 * Created by tho nguyen on 2019-05-09.
 */
class CounterViewModel : ViewModel() {

    val counter = MutableLiveData<Count>().apply {
        value = Count()
    }


    fun onButtonClick() {
        counter.value = counter.value.apply { this!!.index++ }

    }

}
