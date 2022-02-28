package com.toch.algoliaapp.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "delete_hit_table")
data class DeleteHitRoom (
    @PrimaryKey(autoGenerate = false)
    val id: Long
)