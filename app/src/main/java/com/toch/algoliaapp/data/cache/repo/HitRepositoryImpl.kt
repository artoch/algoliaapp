package com.toch.algoliaapp.data.cache.repo

import com.toch.algoliaapp.data.cache.dao.HitDao
import com.toch.algoliaapp.data.cache.entities.DeleteHitRoom
import com.toch.algoliaapp.data.cache.entities.HitRoom
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HitRepositoryImpl @Inject constructor(
    private val hitDao: HitDao
): HitRepository {

    override suspend fun getData(): List<HitRoom> = hitDao.getData()

    override suspend fun getData(noAvailable: List<Long>): List<HitRoom> = hitDao.getData(noAvailable)

    override suspend fun getDeleteData(): List<Long> = hitDao.getDeleteData().map { it.id }

    override suspend fun addDeleteData(hit: DeleteHitRoom) {
        hitDao.addDeleteData(hit)
    }

    override suspend fun addData(hits: List<HitRoom>) {
        hitDao.addData(hits)
    }

    override suspend fun deleteData() {
        hitDao.deleteData()
    }

    override suspend fun deleteData(hit: HitRoom) {
        hitDao.deleteData(hit)
    }

}