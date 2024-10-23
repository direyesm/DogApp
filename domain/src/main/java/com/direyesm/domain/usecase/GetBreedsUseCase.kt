package com.direyesm.domain.usecase

import com.direyesm.domain.repository.DogRepository

class GetBreedsUseCase(private val dogRepository: DogRepository) {
    suspend fun getBreeds(): List<String> {
        val breedsMap = dogRepository.getBreeds()
        return breedsMap.keys.toList() // Convertir las claves del Map (razas) a una lista
    }
}