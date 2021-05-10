package com.vkpriesniakov.imaginesoft.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.vkpriesniakov.baseclasses.BaseActivity
import com.vkpriesniakov.imaginesoft.databinding.ActivityMainBinding

class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}