package com.vkpriesniakov.imaginesoft.network.ktor

import com.vkpriesniakov.baseclasses.BaseDataSource
import com.vkpriesniakov.imaginesoft.data.entity.FlickrGalleryPage
import com.vkpriesniakov.imaginesoft.utils.API_FLICKR
import com.vkpriesniakov.imaginesoft.utils.FETCH_RECENT_METHOD
import com.vkpriesniakov.imaginesoft.utils.FLICKR_API_KEY
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class FlickrDataSource
@Inject
constructor(val client: HttpClient) : BaseDataSource() {

    suspend fun getRaw(pageNum: Int, order_by: String) =
        client.get<FlickrGalleryPage>(
            "$API_FLICKR?method=${FETCH_RECENT_METHOD}&format=json&api_key=$FLICKR_API_KEY"
        ) {

            headers {
                append("method", FETCH_RECENT_METHOD)
                append("sort", order_by)
                append("page", pageNum.toString())
                append("per_page", "10")
                append("format", "json")
                append("api_key", FLICKR_API_KEY)
                append(HttpHeaders.Accept, "json")
                append(HttpHeaders.Authorization, "token")
                append(HttpHeaders.UserAgent, "ktor client")
            }
        }
}