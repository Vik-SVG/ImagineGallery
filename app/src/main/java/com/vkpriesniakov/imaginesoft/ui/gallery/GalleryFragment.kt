package com.vkpriesniakov.imaginesoft.ui.gallery

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentGalleryBinding
import com.vkpriesniakov.imaginesoft.ui.gallery.adapter.GalleryPagerAdapter
import com.vkpriesniakov.imaginesoft.utils.setCubeTransformer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GalleryFragment :
    BaseFragment<FragmentGalleryBinding, GalleryViewModel>(FragmentGalleryBinding::inflate) {

    @Inject
    lateinit var mAdapter: GalleryPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showStatusBar()
        setupPager()
        setupTabs()
    }

    private fun setupPager() {
        binding?.galleryPager?.apply {
            adapter = mAdapter
            setCubeTransformer()
        }
    }

    private fun setupTabs() {
        TabLayoutMediator(
            binding?.tabs!!,
            binding?.galleryPager!!
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Interest"
                1 -> tab.text = "Favorite"
                2 -> tab.text = "Trend"
            }
        }.attach()
    }

    private fun showStatusBar() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }
}