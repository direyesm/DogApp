package com.direyesm.domain.repository

interface DogRepository {
    suspend fun getBreeds(): Map<String, List<String>>
    suspend fun getBreedImages(breed: String): String
}