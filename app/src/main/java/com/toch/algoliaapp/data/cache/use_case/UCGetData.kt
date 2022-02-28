package com.toch.algoliaapp.data.cache.use_case

import com.toch.algoliaapp.data.cache.entities.toDomain
import com.toch.algoliaapp.data.cache.repo.HitRepository
import javax.inject.Inject

class UCGetData @Inject constructor(
    private val hitRepository: HitRepository
) {

    suspend operator fun invoke() = hitRepository.getData(hitRepository.getDeleteData()).map { it.toDomain() }

}