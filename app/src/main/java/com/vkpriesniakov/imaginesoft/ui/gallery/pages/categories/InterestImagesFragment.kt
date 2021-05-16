package com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories

import androidx.paging.PagingData
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllFragment
import kotlinx.coroutines.flow.Flow

class InterestImagesFragment : ImagesAllFragment() {
    override fun imagesFlow(): Flow<PagingData<FlickrImageResponse>> =
        viewModel.fetchAllImagesInteresting()

    companion object {
        fun newInstance() = FavoritesImagesFragment()
    }
}