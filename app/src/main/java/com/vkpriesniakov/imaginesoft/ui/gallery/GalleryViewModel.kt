package com.vkpriesniakov.imaginesoft.ui.gallery

import com.vkpriesniakov.baseclasses.BaseViewModel
import com.vkpriesniakov.imaginesoft.data.repo.GalleryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel
@Inject constructor(private val repo: GalleryRepo) : BaseViewModel() {

    val _sortOrder = MutableStateFlow("latest")
    val sortOrder: StateFlow<String> = _sortOrder

}