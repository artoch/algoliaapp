package com.toch.algoliaapp.di.data.remote.api_service

import com.toch.algoliaapp.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit : Retrofit):ApiService = retrofit.create(ApiService::class.java)

}