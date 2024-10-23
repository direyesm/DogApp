package com.direyesm.data.di

import com.direyesm.domain.repository.DogRepository
import com.direyesm.domain.usecase.GetBreedImagesUseCase
import com.direyesm.domain.usecase.GetBreedsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBreedsUseCase(
        dogRepository: DogRepository
    ): GetBreedsUseCase {
        return GetBreedsUseCase(dogRepository)
    }

    @Provides
    @Singleton
    fun provideGetBreedImagesUseCase(
        dogRepository: DogRepository
    ): GetBreedImagesUseCase {
        return GetBreedImagesUseCase(dogRepository)
    }
}