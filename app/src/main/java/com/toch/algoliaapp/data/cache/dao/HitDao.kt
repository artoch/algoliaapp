package com.toch.algoliaapp.data.cache.dao

import androidx.room.*
import com.toch.algoliaapp.data.cache.entities.DeleteHitRoom
import com.toch.algoliaapp.data.cache.entities.HitRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface HitDao {

    @Query("SELECT * FROM hit_table")
    suspend fun getData(): List<HitRoom>

    @Query("SELECT * FROM hit_table WHERE hit_table.id NOT IN (:noAvailable)")
    suspend fun getData(noAvailable: List<Long>): List<HitRoom>

    @Query("SELECT * FROM delete_hit_table")
    suspend fun getDeleteData(): List<DeleteHitRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(hits: List<HitRoom>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDeleteData(hit: DeleteHitRoom)

    @Query("DELETE FROM hit_table")
    suspend fun deleteData()

    @Delete
    suspend fun deleteData(hit: HitRoom)

}