package com.vkpriesniakov.baseclasses

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding?, VM : BaseViewModel?>(private val fInflate: FragmentInflate<VB>) :
    Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding

    private var mActivity: BaseActivity<*, *>? = null
    private var mRootView: View? = null

    protected var mViewModel: VM? = null

    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity: BaseActivity<*, *> = context
            mActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = fInflate.invoke(inflater, container, false)
        mRootView = binding?.root
        return mRootView
    }

    override fun onDetach() {
        _binding = null
        mActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    val baseActivity: BaseActivity<*, *>?
        get() = mActivity

    fun hideKeyboard() = mActivity?.hideKeyboard()

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String?)
    }
}
