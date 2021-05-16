package com.vkpriesniakov.imaginesoft.data.entity



data class FlickrGalleryPage(
    var photos: PhotoPages,
    var stat: String
)

data class PhotoPages(
    var page: Int,
    var pages: Int,
    var perpage: Int,
    var total: Int,
    var photo: List<FlickrImageResponse>

)

data class FlickrImageResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    var title: String
)



