package com.vkpriesniakov.imaginesoft.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.data.paging.FavoritesDatasource
import com.vkpriesniakov.imaginesoft.data.paging.PopularPhotosDatasource
import com.vkpriesniakov.imaginesoft.data.paging.RecentPhotosDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GalleryRepo
@Inject constructor
    (
    val datasourceFavorites: FavoritesDatasource,
    val datasourcePopular: PopularPhotosDatasource,
    val datasourceRecent: RecentPhotosDatasource
) {

    fun getImagesFlow(
        pagingConfig: PagingConfig = getDefaultPageConfig()
    ): Flow<PagingData<FlickrImageResponse>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory =
            { datasourceFavorites })
            .flow
    }

    fun getRecentImagesFlow(
        pagingConfig: PagingConfig = getDefaultPageConfig()
    ): Flow<PagingData<FlickrImageResponse>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory =
            { datasourcePopular })
            .flow
    }

    fun getPopImagesFlow(
        pagingConfig: PagingConfig = getDefaultPageConfig()
    ): Flow<PagingData<FlickrImageResponse>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory =
            { datasourceRecent })
            .flow
    }


    private fun getDefaultPageConfig(): PagingConfig = PagingConfig(
        pageSize = 10,
        prefetchDistance = 10,
        enablePlaceholders = false,
//        initialLoadSize = 20,
//        maxSize = 60
    )
}