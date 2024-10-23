package com.direyesm.domain.usecase

import com.direyesm.domain.repository.DogRepository

class GetBreedImagesUseCase(private val dogRepository: DogRepository) {
    suspend fun getBreedImages(breed: String): String {
        return dogRepository.getBreedImages(breed)
    }
}
