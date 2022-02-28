package com.toch.algoliaapp.data.cache.use_case

import com.toch.algoliaapp.data.cache.entities.HitRoom
import com.toch.algoliaapp.data.cache.repo.HitRepository
import javax.inject.Inject

class UCAddData @Inject constructor(
    private val hitRepository: HitRepository
){

    suspend operator fun invoke(hits: List<HitRoom>) {
        hitRepository.addData(hits)
    }

}