package com.toch.algoliaapp.di.data.remote.repository

import com.toch.algoliaapp.data.remote.repo_ser.api_service.repository.NewRepository
import com.toch.algoliaapp.data.remote.repo_ser.api_service.repository.NewRepositoryImpl
import com.toch.algoliaapp.data.remote.repo_ser.api_service.service.NewService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewRepositoryModule(service: NewService): NewRepository = NewRepositoryImpl(service)

}