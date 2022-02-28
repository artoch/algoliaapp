package com.toch.algoliaapp.data.remote.repo_ser.api_service.repository

import com.toch.algoliaapp.model.HitDomain

interface NewRepository {

    suspend fun getData(): List<HitDomain>

}