package com.toch.algoliaapp.di.data.cache.repository

import com.toch.algoliaapp.data.cache.dao.HitDao
import com.toch.algoliaapp.data.cache.repo.HitRepository
import com.toch.algoliaapp.data.cache.repo.HitRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object CacheRepositoryModule {

    @Singleton
    @Provides
    fun provideRepositoryModule(hitDao: HitDao): HitRepository = HitRepositoryImpl(hitDao)

}