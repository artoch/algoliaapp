package com.toch.algoliaapp.di.data.domain.repository

import com.toch.algoliaapp.data.cache.use_case.UCAddData
import com.toch.algoliaapp.data.cache.use_case.UCDeleteData
import com.toch.algoliaapp.data.cache.use_case.UCGetData
import com.toch.algoliaapp.data.remote.use_case.UCGetHit
import com.toch.algoliaapp.data.repository.HitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
class HitDomainRepositoryModule {

    @Singleton
    @Provides
    fun provideHitDomainRepositoryModule(
        ucGetHit: UCGetHit,
        ucGetData: UCGetData,
        ucDeleteData: UCDeleteData,
        ucAddData: UCAddData
    ) = HitRepository(ucGetHit, ucGetData, ucDeleteData, ucAddData)

}