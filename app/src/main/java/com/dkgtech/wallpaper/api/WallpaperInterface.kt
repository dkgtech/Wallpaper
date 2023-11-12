package com.dkgtech.wallpaper.api

import android.telecom.Call
import com.dkgtech.wallpaper.model.WallpaperModel
import com.dkgtech.wallpaper.model.WallpaperModelItem
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperInterface {

    @GET("photos")
    fun getPhotos(
        @Query("client_id") client_id: String,
        @Query("per_page") per_page: Int
    ): retrofit2.Call<List<WallpaperModelItem>>
}