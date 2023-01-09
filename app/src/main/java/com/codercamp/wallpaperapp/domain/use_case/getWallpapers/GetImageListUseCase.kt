package com.codercamp.wallpaperapp.domain.use_case.getWallpapers

import com.codercamp.wallpaperapp.common.Resource
import com.codercamp.wallpaperapp.data.remote.dto.ImageListDto
import com.codercamp.wallpaperapp.data.remote.dto.toImageList
import com.codercamp.wallpaperapp.domain.model.ImageLists
import com.codercamp.wallpaperapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(page:String): kotlinx.coroutines.flow.Flow<Resource<List<ImageLists>>> = flow {
        try {
            emit(Resource.Loading<List<ImageLists>>())
            val imageList = repository.getImageList(page,30).map { it.toImageList() }
            emit(Resource.Success<List<ImageLists>>(imageList))
        } catch(e: HttpException) {
            emit(Resource.Error<List<ImageLists>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<ImageLists>>("Couldn't reach server. Check your internet connection."))
        }
    }
}