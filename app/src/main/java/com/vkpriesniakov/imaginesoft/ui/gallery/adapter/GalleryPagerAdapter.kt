package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images.ImagesAllFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.FavoritesImagesFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.InterestImagesFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.ViewsImagesFragment
import com.vkpriesniakov.imaginesoft.utils.ALL_IMAGES_ARGS_KEY
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class GalleryPagerAdapter
@Inject constructor(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(p0: Int): Fragment {

        return when (p0) {
            1 -> InterestImagesFragment.newInstance()
            2 -> ViewsImagesFragment.newInstance()
            else -> FavoritesImagesFragment.newInstance()
        }
    }
}