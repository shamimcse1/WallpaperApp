package com.codercamp.wallpaperapp.presentation.wallpaperList.adapter

import com.codercamp.wallpaperapp.domain.model.ImageLists

interface OnItemClick {
    fun onItemSelected(position: Int, item: ImageLists)
}