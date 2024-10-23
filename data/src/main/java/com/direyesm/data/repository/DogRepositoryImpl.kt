package com.direyesm.data.repository

import com.direyesm.data.remote.DogApiService
import com.direyesm.domain.repository.DogRepository


class DogRepositoryImpl(private val apiService: DogApiService) : DogRepository {
    override suspend fun getBreeds(): Map<String, List<String>> {
        val response = apiService.getBreeds()
        return response.message
    }
    override suspend fun getBreedImages(breed: String): String {
        val response = apiService.getBreedImages(breed)
        return response.message
    }
}
