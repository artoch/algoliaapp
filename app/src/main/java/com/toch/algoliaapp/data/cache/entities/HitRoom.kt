package com.toch.algoliaapp.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.utils.EMPTY_STRING

@Entity(tableName = "hit_table")
data class HitRoom (
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val _tags: List<String>,
    val author: String?,
    val comment_text: String?,
    val created_at: String,
    val created_at_i: Int,
    val num_comments: String?,
    val parent_id: Int?,
    val points: String?,
    val story_id: Int?,
    val story_text: String?,
    val story_title: String?,
    val story_url: String?,
    val title: String?,
    val url: String?
)

fun HitRoom.toDomain() = HitDomain(
    id, _tags, author, comment_text, created_at, created_at_i, num_comments, parent_id, points, story_id, story_text, story_title, story_url, title, url
)

fun HitRoom.toDeleteData() = DeleteHitRoom(
    id
)