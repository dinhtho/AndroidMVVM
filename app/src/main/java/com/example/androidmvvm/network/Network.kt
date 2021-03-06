package com.example.androidmvvm.network

import kotlinx.coroutines.*

/**
 * Created by tho nguyen on 2019-05-15.
 */
object Network {
    fun <T> request(
        call: Deferred<T>,
        success: ((response: T?) -> Unit)?,
        error: ((throwable: Throwable) -> Unit)? = null,
        doOnSubscribe: (() -> Unit)? = null,
        doOnTerminate: (() -> Unit)? = null
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            doOnSubscribe?.invoke()
            try {
                success?.invoke(call.await())
            } catch (t: Throwable) {
                error?.invoke(t)
            } finally {
                doOnTerminate?.invoke()
            }
        }
    }
}