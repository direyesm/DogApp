package com.direyesm.dogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.direyesm.domain.usecase.GetBreedImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogImagesViewModel @Inject constructor(
    private val getBreedImagesUseCase: GetBreedImagesUseCase
) : ViewModel() {

    private val _image = MutableStateFlow<String>("")
    val image: StateFlow<String> = _image

    fun fetchBreedImage(breed: String) {
        viewModelScope.launch {
            _image.value = ""
            try {
                _image.value = getBreedImagesUseCase.getBreedImages(breed)
            } catch (e: Exception) {
                _image.value = ""
            }
        }
    }
}

