package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.new_images.ImagesNewFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.trend_images.ImagesTrendFragment
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class GalleryPagerAdapter
@Inject constructor(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(p0: Int): Fragment {
        val fragment = ImagesAllFragment.newInstance()

        //TODO sort order args

        when (p0) {
            0 -> ImagesAllFragment.newInstance()
            1 -> ImagesNewFragment.newInstance()
            else -> ImagesTrendFragment.newInstance()
        }
        return fragment
    }
}