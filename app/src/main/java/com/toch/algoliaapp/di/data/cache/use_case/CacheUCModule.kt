package com.toch.algoliaapp.di.data.cache.use_case

import com.toch.algoliaapp.data.cache.repo.HitRepository
import com.toch.algoliaapp.data.cache.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object CacheUCModule {

    @Singleton
    @Provides
    fun provideCacheUCAddModule(repository: HitRepository) = UCAddData(repository)

    @Singleton
    @Provides
    fun provideCacheUCDeleteModule(repository: HitRepository) = UCDeleteData(repository)

    @Singleton
    @Provides
    fun provideCacheUCGetModule(repository: HitRepository) = UCGetData(repository)

    @Singleton
    @Provides
    fun provideCacheUCGetDeleteModule(repository: HitRepository) = UCGetDeleteData(repository)

    @Singleton
    @Provides
    fun provideCacheUCAddDeleteModule(repository: HitRepository) = UCAddDeleteData(repository)

}