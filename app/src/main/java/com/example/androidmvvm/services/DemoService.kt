package com.example.androidmvvm.services

import com.example.androidmvvm.model.User
import com.example.androidmvvm.network.Network
import com.example.stackoverflowuser.network.NetworkProvider
import kotlinx.coroutines.Deferred

/**
 * Created by tho nguyen on 2019-06-05.
 */
class DemoService {

    companion object {
        val BASE_URL = "http://uinames.com/"

        fun getUser(): Deferred<User> {
            val restUserService = NetworkProvider.instance.provideApi(BASE_URL, RestDemoService::class.java)
            return restUserService.getUser()
        }
    }
}