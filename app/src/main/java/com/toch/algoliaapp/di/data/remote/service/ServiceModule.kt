package com.toch.algoliaapp.di.data.remote.service

import com.toch.algoliaapp.data.remote.api.ApiService
import com.toch.algoliaapp.data.remote.repo_ser.api_service.service.NewService
import com.toch.algoliaapp.data.remote.repo_ser.api_service.service.NewServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object ServiceModule {

    @Singleton
    @Provides
    fun provideNewServiceModule(api: ApiService): NewService = NewServiceImpl(api)

}