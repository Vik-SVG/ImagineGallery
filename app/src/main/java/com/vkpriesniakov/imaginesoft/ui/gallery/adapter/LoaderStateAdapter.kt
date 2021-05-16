package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vkpriesniakov.imaginesoft.R

class LoaderStateAdapter
constructor
    (private val retry: () -> Unit) :
    LoadStateAdapter<LoaderStateAdapter.LoaderViewHolder>() {


    inner class LoaderViewHolder(val view: View, retry: () -> Unit) :
        RecyclerView.ViewHolder(view) {
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        fun bind(loadState: LoadState) {
            progressBar.isVisible = loadState is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_image, parent, false)
        return LoaderViewHolder(view, retry)
    }

}