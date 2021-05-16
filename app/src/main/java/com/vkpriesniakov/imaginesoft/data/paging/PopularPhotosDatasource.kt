package com.vkpriesniakov.imaginesoft.data.paging

import com.vkpriesniakov.imaginesoft.data.paging.default_source.ImagesPagingSource
import com.vkpriesniakov.imaginesoft.network.retrofit.FlickrService
import com.vkpriesniakov.imaginesoft.utils.FETC_POPULAR_METHOD
import javax.inject.Inject

class PopularPhotosDatasource @Inject
constructor(datasource: FlickrService) : ImagesPagingSource(datasource) {
    override val method: String = FETC_POPULAR_METHOD
}
