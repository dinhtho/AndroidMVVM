package com.example.androidmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.androidmvvm.model.Count
import com.example.androidmvvm.model.User
import com.example.androidmvvm.network.Network
import com.example.androidmvvm.services.DemoService

/**
 * Created by tho nguyen on 2019-05-09.
 */
class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"

    val counter = MutableLiveData<Count>().apply {
        value = Count()
    }

    val userRetrofit = MutableLiveData<User>()

    val isLoading = MutableLiveData<Boolean>().apply { value = false }


    fun onButtonClick() {
        counter.value = counter.value.apply { this!!.index++ }
    }

    fun getUser() {
        Network.request(
                call = DemoService.getUser(),
                success = { user -> userRetrofit.value = user },
                doOnSubscribe = { isLoading.value = true },
                doOnTerminate = { isLoading.value = false },
                error = { throwable -> Log.d(TAG, "getUser: " + throwable.message) }
        )
    }

}
