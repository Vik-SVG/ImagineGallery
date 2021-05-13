package com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentAllImagesBinding
import com.vkpriesniakov.imaginesoft.ui.gallery.GalleryViewModel
import com.vkpriesniakov.imaginesoft.utils.LOG_TAG
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImagesAllFragment :
    BaseFragment<FragmentAllImagesBinding, ImagesAllViewModel>(FragmentAllImagesBinding::inflate) {

    val viewModel: ImagesAllViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getImageLiveData("latest").observe(viewLifecycleOwner, {

            Log.d(LOG_TAG, it.message.toString())
            Log.d(LOG_TAG, it.data?.get(0)?.urls?.raw.toString())
        })
    }

    companion object {
        fun newInstance() = ImagesAllFragment().apply {

        }
    }
}