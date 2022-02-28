package com.toch.algoliaapp.data.remote.repo_ser.api_service.service

import com.toch.algoliaapp.data.remote.dto.NewDto

interface NewService {

    suspend fun getData(): NewDto

}