package com.vkpriesniakov.imaginesoft.data.paging.default_source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.network.retrofit.FlickrService
import com.vkpriesniakov.imaginesoft.utils.LOG_TAG
import java.io.IOException

abstract class ImagesPagingSource
    (
    val datasource: FlickrService,
) :
    PagingSource<Int, FlickrImageResponse>() {

    abstract val method: String

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FlickrImageResponse> {

        val page = params.key ?: 1

        Log.d(LOG_TAG, method)

        return try {
            val response = datasource.getImages(page, method)

            LoadResult.Page(
                data = response.body()?.photos?.photo ?: emptyList(),
                nextKey = page + 1,
                prevKey = if (page == 1) null else page - 1
            )

        } catch (exc: IOException) {

            LoadResult.Error(exc)

        } catch (exc: HttpException) {

            LoadResult.Error(exc)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, FlickrImageResponse>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)
                ?: anchorPage?.nextKey?.minus(1)
        }
    }
}