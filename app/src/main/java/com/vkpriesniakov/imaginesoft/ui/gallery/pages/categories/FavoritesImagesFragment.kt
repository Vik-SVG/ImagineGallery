package com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories

import androidx.paging.PagingData
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllFragment
import kotlinx.coroutines.flow.Flow

class FavoritesImagesFragment : ImagesAllFragment() {
    override fun imagesFlow(): Flow<PagingData<FlickrImageResponse>> =
        viewModel.fetchAllImagesViews()

    companion object {
        fun newInstance() = FavoritesImagesFragment()
    }
}