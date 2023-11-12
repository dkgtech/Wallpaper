package com.dkgtech.wallpaper.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.wallpaper.databinding.PhotosRowBinding
import com.dkgtech.wallpaper.model.WallpaperModel
import com.dkgtech.wallpaper.model.WallpaperModelItem
import com.dkgtech.wallpaper.ui.PhotoDetailActivity
import com.squareup.picasso.Picasso

class RecyclerWallpaperAdapter(val context: Context, val arrData: MutableList<WallpaperModelItem>) :
    RecyclerView.Adapter<RecyclerWallpaperAdapter.ViewHolder>() {
    class ViewHolder(val binding: PhotosRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PhotosRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Picasso.get().load(arrData[position].urls.small).into(imgPhoto)
            ccView.setOnClickListener {
                context.startActivity(
                    Intent(context, PhotoDetailActivity::class.java).putExtra(
                        "Photo",
                        arrData[position].urls.small
                    )
                )
            }

        }
    }
}