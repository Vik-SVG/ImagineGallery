package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.databinding.ItemImageBinding
import com.vkpriesniakov.imaginesoft.utils.FLICKR_IMAGE_URL
import javax.inject.Inject


class ImagePagingAdapter
@Inject constructor() :
    PagingDataAdapter<FlickrImageResponse, ImagePagingAdapter.ImagesViewHolder>(ImagesComparator) {

    lateinit var clickCallback: (url: String) -> Unit

    inner class ImagesViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: FlickrImageResponse?, position: Int) {

            ViewCompat.setTransitionName(binding.root, "item_image")

            val imageUrl = "$FLICKR_IMAGE_URL${item?.server}/${item?.id}_${item?.secret}_w.jpg"

            val imageUrlFull = "$FLICKR_IMAGE_URL${item?.server}/${item?.id}_${item?.secret}_h.jpg"

            Glide.with(binding.root.context)
                .asBitmap()
                .load(imageUrl)
                .fitCenter()
                .into(binding.imageView2)

            binding.root.setOnClickListener {
                clickCallback.invoke(imageUrlFull)
            }
        }
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {

        val binding = ItemImageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesViewHolder(binding)
    }

    object ImagesComparator : DiffUtil.ItemCallback<FlickrImageResponse>() {
        override fun areItemsTheSame(
            oldItem: FlickrImageResponse,
            newItem: FlickrImageResponse
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: FlickrImageResponse,
            newItem: FlickrImageResponse
        ): Boolean =
            oldItem.secret == newItem.secret
    }
}