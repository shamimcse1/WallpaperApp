package com.codercamp.wallpaperapp.presentation.wallpaperList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codercamp.wallpaperapp.common.Constants
import com.codercamp.wallpaperapp.common.Resource
import com.codercamp.wallpaperapp.common.Status
import com.codercamp.wallpaperapp.domain.use_case.getWallpapers.GetImageListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageList: GetImageListUseCase,
) : ViewModel() {

    private val _status = mutableStateOf(Status())
    val status: State<Status> = _status

    fun getImages(page: String) {
        getImageList(page).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _status.value = Status(images = result.data!!)
                }
                is Resource.Error -> {
                    _status.value = Status(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _status.value = Status(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}