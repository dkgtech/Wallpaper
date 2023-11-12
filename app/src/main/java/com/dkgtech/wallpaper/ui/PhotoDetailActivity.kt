package com.dkgtech.wallpaper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dkgtech.wallpaper.R
import com.dkgtech.wallpaper.databinding.ActivityPhotoDetailBinding
import com.squareup.picasso.Picasso

class PhotoDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val intent = intent.getStringExtra("Photo")
            Picasso.get().load(intent).into(imgPhotoMain)
        }
    }
}