package com.vkpriesniakov.imaginesoft.ui.gallery.open_image

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.R
import com.vkpriesniakov.imaginesoft.databinding.FragmentOpenImageBinding
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllViewModel
import com.vkpriesniakov.imaginesoft.utils.OPEN_IMAGE_KEY

class OpenImageFragment :
    BaseFragment<FragmentOpenImageBinding, ImagesAllViewModel>(FragmentOpenImageBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = getArgumentsUrl()
        ViewCompat.setTransitionName(binding?.fullImage!!, "hero_image")

        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_transition)


        loadImage(url)
    }

    private fun getArgumentsUrl(): String? {
        binding?.openImageProgressBar?.isVisible = true
        val url = arguments?.getString(OPEN_IMAGE_KEY)
        return url
    }

    private fun loadImage(url: String?) {
        binding?.fullImage?.let {
            Glide.with(requireContext())
                .asDrawable()
                .load(url)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        it.setImageDrawable(resource)
                        binding?.openImageProgressBar?.isVisible = false
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        }
    }
}