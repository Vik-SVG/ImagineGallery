package com.vkpriesniakov.imaginesoft.ui.gallery.pages.all_images

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.paging.PagingData
import androidx.paging.flatMap
import androidx.paging.map
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vkpriesniakov.baseclasses.BaseFragment
import com.vkpriesniakov.imaginesoft.R
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.databinding.FragmentAllImagesBinding
import com.vkpriesniakov.imaginesoft.ui.gallery.adapter.ImagePagingAdapter
import com.vkpriesniakov.imaginesoft.ui.gallery.adapter.LoaderStateAdapter
import com.vkpriesniakov.imaginesoft.ui.gallery.open_image.OpenImageFragment
import com.vkpriesniakov.imaginesoft.utils.OPEN_IMAGE_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
abstract class ImagesAllFragment :
    BaseFragment<FragmentAllImagesBinding, ImagesAllViewModel>(FragmentAllImagesBinding::inflate) {

    val viewModel: ImagesAllViewModel by viewModels()

    @Inject
    lateinit var pagingAdapter: ImagePagingAdapter

    var subscribeJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        makeImagesJob()

        setPullToRefresh()


        pagingAdapter.clickCallback = { url, view ->


            ViewCompat.setTransitionName(view, "item_image")

            val extraNav = FragmentNavigatorExtras(view to "hero_image")

            val bundle = bundleOf(OPEN_IMAGE_KEY to url)

            requireActivity().findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_galleryFragment_to_openImageFragment, bundle, null, extraNav)
        }
    }

    private fun setPullToRefresh() {
        binding?.swiperefresh?.apply {
            setOnRefreshListener {
                makeImagesJob()
            }
        }

    }

    private fun makeImagesJob() {
        subscribeJob = null
        subscribeJob = subscribeToImages()
        pagingAdapter.notifyDataSetChanged()
        binding?.swiperefresh?.isRefreshing = false
    }

    abstract fun imagesFlow(): Flow<PagingData<FlickrImageResponse>>

    private fun subscribeToImages(): Job {
        return lifecycleScope.launch {
            imagesFlow().makeSubscription()
        }
    }

    private suspend fun Flow<PagingData<FlickrImageResponse>>.makeSubscription() {
        this.collectLatest {
            pagingAdapter.submitData(it)
        }
    }


    private fun setupRecyclerView() {
        binding?.allImagesRecycler?.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(false)
            val loadStateAdapter = LoaderStateAdapter {
                pagingAdapter.retry()
            }
            adapter = pagingAdapter.withLoadStateFooter(loadStateAdapter)

        }
    }
}