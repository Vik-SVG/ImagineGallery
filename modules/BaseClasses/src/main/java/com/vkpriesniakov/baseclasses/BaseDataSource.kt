package com.vkpriesniakov.baseclasses

import android.util.Log

abstract class BaseDataSource {

    protected suspend fun <T> getResults(call: suspend () -> T): Resource<T> {
        return try {
            val response = call.invoke()
            Log.i("BaseDataSource", response.toString())
            Resource.success(response)
        } catch (e: Exception) {
            error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Log.d("BaseDataSource", message)
        return Resource.error("Network call has failed because of next reason: $message")
    }
}