package com.codercamp.wallpaperapp.data.repository

import com.codercamp.wallpaperapp.common.Constants.API_KEY
import com.codercamp.wallpaperapp.data.remote.Api
import com.codercamp.wallpaperapp.data.remote.dto.ImageListDto
import com.codercamp.wallpaperapp.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: Api
) : ImageRepository {

    override suspend fun getImageList(page: String, per_page: Int): List<ImageListDto> {
        return  api.getImageList(page,per_page,API_KEY)
    }
}