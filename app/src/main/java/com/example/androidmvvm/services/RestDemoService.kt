package com.example.androidmvvm.services

import com.example.androidmvvm.model.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Created by tho nguyen on 2019-06-05.
 */
interface RestDemoService {
    @GET("api")
    fun getUser(): Deferred<User>
}