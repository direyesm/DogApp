package com.direyesm.data.remote

import com.direyesm.data.remote.models.BreedsImagesResponse
import com.direyesm.data.remote.models.BreedsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {
    @GET("api/breeds/list/all")
    suspend fun getBreeds(): BreedsResponse

    @GET("api/breed/{breed}/images/random")
    suspend fun getBreedImages(
        @Path("breed")
        breed: String
    ): BreedsImagesResponse
}
