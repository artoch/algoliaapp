package com.toch.algoliaapp.di.data.remote.use_case

import com.toch.algoliaapp.data.remote.repo_ser.api_service.repository.NewRepository
import com.toch.algoliaapp.data.remote.use_case.UCGetHit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object UseCaseModule {

    @Singleton
    @Provides
    fun provideUCNewModule(repository: NewRepository) = UCGetHit(repository)

}