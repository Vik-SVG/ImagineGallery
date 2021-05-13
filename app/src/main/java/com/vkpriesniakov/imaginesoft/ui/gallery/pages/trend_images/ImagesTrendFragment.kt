package com.vkpriesniakov.imaginesoft.ui.gallery.pages.trend_images

import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentTrendImagesBinding

class ImagesTrendFragment :
    BaseFragment<FragmentTrendImagesBinding, ImagesTrendViewModel>(FragmentTrendImagesBinding::inflate) {


    companion object {
        fun newInstance() = ImagesTrendFragment()
    }
}