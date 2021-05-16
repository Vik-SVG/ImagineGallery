package com.vkpriesniakov.imaginesoft.ui.splash

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.findNavController
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.R
import com.vkpriesniakov.imaginesoft.databinding.FragmentSplashBinding

class SplashFragment :
    BaseFragment<FragmentSplashBinding, SplashViewModel>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onSplashEnding()
    }

    private fun onSplashEnding() {
        binding?.apply {
            mainMotion.setTransitionListener(object : MotionLayout.TransitionListener {

                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                    root.findNavController()
                        .navigate(R.id.action_splashFragment_to_galleryFragment)
                }

                override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                }

                override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                }

                override fun onTransitionTrigger(
                    p0: MotionLayout?,
                    p1: Int,
                    p2: Boolean,
                    p3: Float
                ) {
                }
            })
        }
    }
}
