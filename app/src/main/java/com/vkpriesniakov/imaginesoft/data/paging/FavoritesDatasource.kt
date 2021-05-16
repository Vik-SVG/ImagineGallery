package com.vkpriesniakov.imaginesoft.data.paging

import com.vkpriesniakov.imaginesoft.data.paging.default_source.ImagesPagingSource
import com.vkpriesniakov.imaginesoft.network.retrofit.FlickrService
import com.vkpriesniakov.imaginesoft.utils.FETCH_FAVORITES_METHOD
import javax.inject.Inject

class FavoritesDatasource
@Inject
constructor(datasource: FlickrService) : ImagesPagingSource(datasource) {
    override val method: String = FETCH_FAVORITES_METHOD
}