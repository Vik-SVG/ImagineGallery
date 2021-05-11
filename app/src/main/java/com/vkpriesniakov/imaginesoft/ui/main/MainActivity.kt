package com.vkpriesniakov.imaginesoft.ui.main

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.vkpriesniakov.baseclasses.BaseActivity
import com.vkpriesniakov.imaginesoft.databinding.ActivityMainBinding

class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}