package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.FavoritesImagesFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.InterestImagesFragment
import com.vkpriesniakov.imaginesoft.ui.gallery.pages.categories.ViewsImagesFragment

class GalleryPagerAdapter
constructor(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(p0: Int): Fragment {

        return when (p0) {
            1 -> InterestImagesFragment.newInstance()
            2 -> ViewsImagesFragment.newInstance()
            else -> FavoritesImagesFragment.newInstance()
        }
    }
}