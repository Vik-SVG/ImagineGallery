package com.vkpriesniakov.imaginesoft.network.retrofit

import com.vkpriesniakov.imaginesoft.data.entity.FlickrGalleryPage
import com.vkpriesniakov.imaginesoft.utils.FETCH_RECENT_METHOD
import com.vkpriesniakov.imaginesoft.utils.FLICKR_API_KEY
import retrofit2.Response
import retrofit2.http.*

interface FlickrService {

    @GET("?format=json&api_key=$FLICKR_API_KEY&nojsoncallback=1")
    suspend fun getImages(
        @Query("page") page: Int,
        @Query("method") method: String
    ): Response<FlickrGalleryPage>
}