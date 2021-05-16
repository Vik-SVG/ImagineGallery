package com.vkpriesniakov.imaginesoft.utils

import android.net.Uri

const val API_KEY = "1F1LBUVgTNxx9A14jlq1Wma2otP_4z4L51WG4SJYD9M"
const val unsplash_api = "https://api.unsplash.com/"
const val IMAGE_HEADER = "photos/"
const val ALL_IMAGES_ARGS_KEY = "AllImagesArgumentsKey"
const val OPEN_IMAGE_KEY = "OpenImageKey"

const val FETCH_RECENT_METHOD = "flickr.photos.getRecent"
const val FETC_POPULAR_METHOD = "flickr.photos.getPopular"
const val FETCH_FAVORITES_METHOD = "flickr.photos.getFavorites"
const val FLICKR_API_KEY = "21e23938cdbb6639a286ec800a1d43b5"
const val API_FLICKR = "https://api.flickr.com/services/rest/"
const val FLICKR_IMAGE_URL = "https://live.staticflickr.com/"

private val ENDPOINT = Uri.parse("https://api.flickr.com/services/rest/")
    .buildUpon()
    .appendQueryParameter("api_key", API_KEY)
    .appendQueryParameter("format", "json")
    .appendQueryParameter("nojsoncallback", "1")
    .appendQueryParameter("extras", "url_s")
    .build()

const val LOG_TAG = "LogTagVal"