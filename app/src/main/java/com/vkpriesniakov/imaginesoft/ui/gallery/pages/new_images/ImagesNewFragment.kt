package com.vkpriesniakov.imaginesoft.ui.gallery.pages.new_images

import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentNewImagesBinding

class ImagesNewFragment :
    BaseFragment<FragmentNewImagesBinding, ImagesNewViewModel>(FragmentNewImagesBinding::inflate) {


    companion object {
        fun newInstance() = ImagesNewFragment()
    }
}