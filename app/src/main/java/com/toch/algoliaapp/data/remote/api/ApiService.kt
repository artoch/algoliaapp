package com.toch.algoliaapp.data.remote.api

import com.toch.algoliaapp.data.remote.dto.NewDto
import retrofit2.http.GET

interface ApiService {

    @GET("search_by_date")
    suspend fun getData(): NewDto

}