package com.vkpriesniakov.imaginesoft.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.vkpriesniakov.baseclasses.Resource
import com.vkpriesniakov.imaginesoft.data.ImageResponse
import com.vkpriesniakov.imaginesoft.network.UnsplashDatasource
import com.vkpriesniakov.imaginesoft.utils.performGetFlowOperation
import javax.inject.Inject

class GalleryRepo
@Inject constructor(private val dataSource: UnsplashDatasource) {
    fun getLivedataResponse(order_by: String): LiveData<Resource<List<ImageResponse>>> = liveData {
        emitSource(
            performGetFlowOperation {
                dataSource.getImagesResource(order_by)
            }.asLiveData()
        )
    }
}
