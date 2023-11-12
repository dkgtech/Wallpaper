package com.dkgtech.wallpaper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dkgtech.wallpaper.adapter.RecyclerWallpaperAdapter
import com.dkgtech.wallpaper.api.WallpaperInterface
import com.dkgtech.wallpaper.databinding.ActivityMainBinding
import com.dkgtech.wallpaper.model.WallpaperModel
import com.dkgtech.wallpaper.model.WallpaperModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//jl_PrdkW_PtlRBoSEzUgWIuoNBR5xjQtWGUeooumLMg
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var photo: MutableList<WallpaperModelItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            getphotos()

        }

    }

    private fun getphotos() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(WallpaperInterface::class.java)

        val response = retrofit.getPhotos("jl_PrdkW_PtlRBoSEzUgWIuoNBR5xjQtWGUeooumLMg", 200)

        response.enqueue(object : Callback<List<WallpaperModelItem>> {
            override fun onResponse(
                call: Call<List<WallpaperModelItem>>,
                response: Response<List<WallpaperModelItem>>
            ) {
                val responseBody = response.body().let {
                    if (it != null) {
                        photo.addAll(it)
                    }
                }
                if (response.isSuccessful) {
                    with(binding) {
                        rcViewPhotos.layoutManager = StaggeredGridLayoutManager(2, 1)
                        rcViewPhotos.adapter = RecyclerWallpaperAdapter(
                            this@MainActivity,
                            photo
                        )
                    }

                }

            }

            override fun onFailure(call: Call<List<WallpaperModelItem>>, t: Throwable) {
                Log.d("Main", "${t.message}")
            }

        })

    }

}