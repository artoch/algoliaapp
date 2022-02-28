package com.toch.algoliaapp.data.cache.repo

import com.toch.algoliaapp.data.cache.entities.DeleteHitRoom
import com.toch.algoliaapp.data.cache.entities.HitRoom

interface HitRepository {

    suspend fun getData(): List<HitRoom>

    suspend fun getData(noAvailable: List<Long>): List<HitRoom>

    suspend fun getDeleteData(): List<Long>

    suspend fun addDeleteData(hit: DeleteHitRoom)

    suspend fun addData(hits: List<HitRoom>)

    suspend fun deleteData()

    suspend fun deleteData(hit: HitRoom)

}