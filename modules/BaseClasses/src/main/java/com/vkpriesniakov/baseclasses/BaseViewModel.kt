package com.vkpriesniakov.baseclasses

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    private var mIsLoading: ObservableBoolean = ObservableBoolean()

}