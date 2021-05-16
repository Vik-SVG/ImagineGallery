package com.vkpriesniakov.imaginesoft.network.ktor

import com.vkpriesniakov.baseclasses.BaseDataSource
import com.vkpriesniakov.imaginesoft.data.entity.ImageResponse
import com.vkpriesniakov.imaginesoft.utils.API_KEY
import com.vkpriesniakov.imaginesoft.utils.IMAGE_HEADER
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

    suspend fun getRaw(pageNum: Int, order_by: String) =
        client.get<List<ImageResponse>>(
            "$unsplash_api$IMAGE_HEADER?page=$pageNum&order_by=$order_by&per_page=10&client_id=$API_KEY"
        ) {
            headers {
                append(HttpHeaders.Accept, "text/html")
                append(HttpHeaders.Authorization, "token")
                append(HttpHeaders.UserAgent, "ktor client")
            }
        }
}