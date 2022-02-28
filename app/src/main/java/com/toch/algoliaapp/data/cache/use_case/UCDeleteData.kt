package com.toch.algoliaapp.data.cache.use_case

import com.toch.algoliaapp.data.cache.entities.HitRoom
import com.toch.algoliaapp.data.cache.entities.toDeleteData
import com.toch.algoliaapp.data.cache.repo.HitRepository
import javax.inject.Inject

class UCDeleteData @Inject constructor(
    private val hitRepository: HitRepository
){

    suspend operator fun invoke() {
        hitRepository.deleteData()
    }

    suspend operator fun invoke(hit: HitRoom) {
        hitRepository.deleteData(hit)
        hitRepository.addDeleteData(hit.toDeleteData())
    }

}