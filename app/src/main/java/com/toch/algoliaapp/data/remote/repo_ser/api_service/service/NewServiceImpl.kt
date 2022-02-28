package com.toch.algoliaapp.data.remote.repo_ser.api_service.service

import com.toch.algoliaapp.data.remote.api.ApiService
import javax.inject.Inject

class NewServiceImpl @Inject constructor(private val api: ApiService): NewService {

    override suspend fun getData() = api.getData()

}