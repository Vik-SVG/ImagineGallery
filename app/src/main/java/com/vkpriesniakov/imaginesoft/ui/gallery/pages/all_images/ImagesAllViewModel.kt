package com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.vkpriesniakov.baseclasses.BaseViewModel
import com.vkpriesniakov.imaginesoft.data.repo.GalleryRepo
import com.vkpriesniakov.imaginesoft.utils.FETCH_FAVORITES_METHOD
import com.vkpriesniakov.imaginesoft.utils.FETCH_RECENT_METHOD
import com.vkpriesniakov.imaginesoft.utils.FETC_POPULAR_METHOD
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ImagesAllViewModel
@Inject constructor(
    private val repo: GalleryRepo,
    val savedState: SavedStateHandle
) : BaseViewModel() {


    fun fetchAllImagesInteresting() =
        repo.getImagesFlow().map { response ->
            response.map { it }
        }.cachedIn(viewModelScope)

    fun fetchAllImagesComments() =
        repo.getRecentImagesFlow().map { response ->
            response.map { it }
        }.cachedIn(viewModelScope)

    fun fetchAllImagesViews() =
        repo.getPopImagesFlow().map { response ->
            response.map { it }
        }.cachedIn(viewModelScope)


}