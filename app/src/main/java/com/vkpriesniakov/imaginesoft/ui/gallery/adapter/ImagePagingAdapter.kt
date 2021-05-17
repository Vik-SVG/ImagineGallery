package com.vkpriesniakov.imaginesoft.ui.gallery.adapter

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.vkpriesniakov.imaginesoft.data.entity.FlickrImageResponse
import com.vkpriesniakov.imaginesoft.databinding.ItemImageBinding
import com.vkpriesniakov.imaginesoft.utils.FLICKR_IMAGE_URL
import javax.inject.Inject


class ImagePagingAdapter
@Inject constructor() :
    PagingDataAdapter<FlickrImageResponse, ImagePagingAdapter.ImagesViewHolder>(ImagesComparator) {

    lateinit var clickCallback: (url: String, view: View) -> Unit

    inner class ImagesViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: FlickrImageResponse?, position: Int) {


            ViewCompat.setTransitionName(binding.root, "item_image")

            val imageUrl = "$FLICKR_IMAGE_URL${item?.server}/${item?.id}_${item?.secret}_w.jpg"

            val imageUrlFull = "$FLICKR_IMAGE_URL${item?.server}/${item?.id}_${item?.secret}_b.jpg"

            Glide.with(binding.root.context)
                .asDrawable()
                .load(imageUrl)
//                .into(binding.imageView2)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        binding.imageView2.setImageDrawable(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                })

            binding.root.setOnClickListener {
                clickCallback.invoke(imageUrlFull, it)
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