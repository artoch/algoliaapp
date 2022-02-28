package com.toch.algoliaapp.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.toch.algoliaapp.data.cache.converter.StringListConverter
import com.toch.algoliaapp.data.cache.dao.HitDao
import com.toch.algoliaapp.data.cache.entities.DeleteHitRoom
import com.toch.algoliaapp.data.cache.entities.HitRoom

@Database(entities = [HitRoom::class, DeleteHitRoom::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverter::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun  getAppDao(): HitDao
}