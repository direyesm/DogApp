package com.direyesm.dogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.direyesm.domain.usecase.GetBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(
    private val getBreedsUseCase: GetBreedsUseCase
) : ViewModel() {

    private val _breeds = MutableStateFlow<List<String>>(emptyList())
    val breeds: StateFlow<List<String>> = _breeds

    init {
        if (_breeds.value.isEmpty()) {
            fetchBreeds()
        }
    }

    private fun fetchBreeds() {
        viewModelScope.launch {
            try {
                _breeds.value = getBreedsUseCase.getBreeds()
            } catch (e: Exception) {
                _breeds.value = emptyList()
            }
        }
    }
}


