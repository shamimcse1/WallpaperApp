package com.codercamp.wallpaperapp.common

import com.codercamp.wallpaperapp.domain.model.ImageLists

data class Status(
    val isLoading: Boolean?= null,
    val images: List<ImageLists>? = null,
    val error: String? = null
)