package com.vkpriesniakov.imaginesoft.data.entity

import com.google.gson.annotations.SerializedName

data class ImageResponse(

    @SerializedName("id")
    val id: String,

    @SerializedName("created_at")
    val created_at: String,

    @SerializedName("likes")
    val likes: Int,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("urls")
    val urls: ImageUrls
)

data class ImageUrls(
    @SerializedName("raw")
    val raw: String,

    @SerializedName("full")
    val full: String,

    @SerializedName("regular")
    val regular: String,

    @SerializedName("small")
    val small: String,

    @SerializedName("thumb")
    val thumb: String
)