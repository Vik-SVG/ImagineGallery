package com.vkpriesniakov.imaginesoft.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.vkpriesniakov.baseclasses.Resource
import com.vkpriesniakov.baseclasses.Resource.Status.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

suspend fun <T> performGetOperation(
    networkCall: suspend () -> Resource<T>
): Resource<T> {

    var response: Resource<T> = Resource.loading(null)

    return when (response.status) {
        SUCCESS -> {
            response
        }
        ERROR -> {
            Resource.error(response.message!!)
        }
        LOADING -> {
            response = networkCall.invoke()
            return response
        }
    }
}

fun <T> performGetLiveDataOperation(
    networkCall: suspend () -> Resource<T>
): LiveData<Resource<T>> {

    return liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            emit(responseStatus)

            Log.i("DataAccessStrategy", responseStatus.status.name)
            Log.i("DataAccessStrategy", responseStatus.data.toString())

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }
}

suspend fun <T> performGetFlowOperation(
    networkCall: suspend () -> Resource<T>
): Flow<Resource<T>> =
    flow {

        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            emit(responseStatus)

            Log.i("DataAccessStrategy", responseStatus.status.name)
            Log.i("DataAccessStrategy", responseStatus.data.toString())

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }