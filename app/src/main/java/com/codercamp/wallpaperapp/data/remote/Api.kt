package com.codercamp.wallpaperapp.data.remote

import com.codercamp.wallpaperapp.common.Constants
import com.codercamp.wallpaperapp.data.remote.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @Headers("Authorization:client_id="+Constants.API_KEY)
    @GET("photos")
    suspend fun getImageList(
        @Query("page") page:String,
        @Query("per_page") per_page:Int,
        @Query("client_id") client_id:String,
    ):List<ImageListDto>
}