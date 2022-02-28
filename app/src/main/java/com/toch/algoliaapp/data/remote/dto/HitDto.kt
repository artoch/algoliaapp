package com.toch.algoliaapp.data.remote.dto

import com.toch.algoliaapp.model.HitDomain

data class HitDto(
    val _tags: List<String>,
    val author: String?,
    val comment_text: String?,
    val created_at: String,
    val created_at_i: Int,
    val num_comments: String?,
    val objectID: Long,
    val parent_id: Int?,
    val points: String?,
    val story_id: Int?,
    val story_text: String?,
    val story_title: String?,
    val story_url: String?,
    val title: String?,
    val url: String?
)

fun HitDto.toDomain() = HitDomain(
    objectID, _tags, author, comment_text, created_at, created_at_i, num_comments, parent_id, points, story_id, story_text, story_title, story_url, title, url
)