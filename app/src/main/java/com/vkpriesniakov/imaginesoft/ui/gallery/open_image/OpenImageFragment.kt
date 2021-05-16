package com.vkpriesniakov.imaginesoft.ui.gallery.open_image

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentOpenImageBinding
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllViewModel
import com.vkpriesniakov.imaginesoft.utils.OPEN_IMAGE_KEY

class OpenImageFragment :
    BaseFragment<FragmentOpenImageBinding, ImagesAllViewModel>(FragmentOpenImageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(OPEN_IMAGE_KEY)

        binding?.fullImage?.let {
            Glide.with(requireContext())
                .load(url)
                .into(it)
        }
    }
}