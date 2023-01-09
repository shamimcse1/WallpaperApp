package com.codercamp.wallpaperapp.domain.repository

import com.codercamp.wallpaperapp.data.remote.dto.ImageListDto

interface ImageRepository {
    suspend fun getImageList(page:String,per_page:Int):List<ImageListDto>
}