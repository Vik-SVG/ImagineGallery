package com.vkpriesniakov.imaginesoft.ui.gallery

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.databinding.FragmentGalleryBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GalleryFragment :
    BaseFragment<FragmentGalleryBinding, GalleryViewModel>(FragmentGalleryBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showStatusBar()
        setupPager()

    }

    private fun setupPager() {
        binding?.mainPager?.apply {
            //            adapter = vpAdapter
            //            registerOnPageChangeCallback(pageChangeCallback)
            orientation = ViewPager2.ORIENTATION_VERTICAL
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
    }

    private fun showStatusBar() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)

            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }
}