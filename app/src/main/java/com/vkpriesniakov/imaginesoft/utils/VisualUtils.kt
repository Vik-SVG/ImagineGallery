package com.vkpriesniakov.imaginesoft.utils

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

 fun ViewPager2.setCubeTransformer() {

     (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

     this.setPageTransformer { view, pos ->
        when {
            (pos < -1) -> view.alpha = 0F
            (pos <= 0) -> view.apply {
                alpha = 1F
                pivotX = view.width.toFloat()
                rotationY = -90 * Math.abs(pos)
            }
            (pos <= 1) -> view.apply {
                alpha = 1F;
                view.pivotX = 0F;
                view.rotationY = 90 * abs(pos)
            }
            else -> view.alpha = 0F
        }
    }
}
