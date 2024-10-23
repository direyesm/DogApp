package com.direyesm.data.di

import com.direyesm.data.remote.DogApiService
import com.direyesm.data.repository.DogRepositoryImpl
import com.direyesm.domain.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDogRepository(apiService: DogApiService): DogRepository {
        return DogRepositoryImpl(apiService)
    }
}