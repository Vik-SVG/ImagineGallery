package com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images

import androidx.lifecycle.LiveData
import com.vkpriesniakov.baseclasses.BaseViewModel
import com.vkpriesniakov.baseclasses.Resource
import com.vkpriesniakov.imaginesoft.data.ImageResponse
import com.vkpriesniakov.imaginesoft.ui.gallery.GalleryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagesAllViewModel
@Inject constructor(private val repo: GalleryRepo) : BaseViewModel() {

    fun getImageLiveData(sort_order: String): LiveData<Resource<List<ImageResponse>>> =
        repo.getLivedataResponse(sort_order)

}