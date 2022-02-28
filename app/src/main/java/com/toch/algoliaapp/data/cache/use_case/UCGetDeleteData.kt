package com.toch.algoliaapp.data.cache.use_case

import com.toch.algoliaapp.data.cache.repo.HitRepository
import javax.inject.Inject

class UCGetDeleteData @Inject constructor(
    private val hitRepository: HitRepository
) {

    suspend operator fun invoke() = hitRepository.getDeleteData()

}