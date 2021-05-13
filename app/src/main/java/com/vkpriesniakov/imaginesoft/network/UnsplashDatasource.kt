package com.vkpriesniakov.imaginesoft.network

import com.vkpriesniakov.baseclasses.BaseDataSource
import com.vkpriesniakov.imaginesoft.data.ImageResponse
import com.vkpriesniakov.imaginesoft.utils.API_KEY
import com.vkpriesniakov.imaginesoft.utils.unsplash_api
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashDatasource
@Inject
constructor(private val client: HttpClient) : BaseDataSource() {

    suspend fun getImagesResource(order_by: String) = getResults {
        client.get<List<ImageResponse>>(unsplash_api + "photos/?client_id=" + API_KEY) {
            headers {
                append(HttpHeaders.Accept, "text/html")
//                append(HttpHeaders.Accept, IMAGE_HEADER)
//                append(HttpHeaders.OrderingType, order_by)
//                append("order_by", order_by)
//                append("page", "1")
//                append("per_page", "10")
                append(HttpHeaders.Authorization, "token")
                append(HttpHeaders.UserAgent, "ktor client")
            }
        }
    }
}