package com.codercamp.wallpaperapp.presentation.wallpaperList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.codercamp.wallpaperapp.common.Constants
import com.codercamp.wallpaperapp.common.Resource
import com.codercamp.wallpaperapp.common.Status
import com.codercamp.wallpaperapp.domain.model.ImageLists
import com.codercamp.wallpaperapp.domain.use_case.getWallpapers.GetImageListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageList: GetImageListUseCase,
) : ViewModel() {

    private var _imageList = MutableLiveData<List<ImageLists>>()
    val imageList: LiveData<List<ImageLists>>
        get() = _imageList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private var _successMessage = MutableLiveData<String>()
    val successMessage: LiveData<String>
        get() = _successMessage

    fun getImages(page: String) {
        getImageList(page).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _isLoading.value = true
                }
                is Resource.Success -> {
                    _isLoading.value = false
                    _imageList.value = result.data!!
                    _successMessage.value = result.message

                }
                is Resource.Error -> {
                    _isLoading.value = false
                    _message.value = result.message ?: "UNEXPECTED_ERROR"
                }

            }
        }.launchIn(viewModelScope)
    }
}