package com.toch.algoliaapp.model

import com.toch.algoliaapp.data.cache.entities.DeleteHitRoom
import com.toch.algoliaapp.data.cache.entities.HitRoom
import com.toch.algoliaapp.utils.EMPTY_STRING

data class HitDomain (
    val id: Long = 0L,
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

fun HitDomain.toRoom() = HitRoom(
    id , _tags, author, comment_text, created_at, created_at_i, num_comments, parent_id, points, story_id, story_text, story_title, story_url, title, url
)

fun HitDomain.getTitle(): String {
    story_title?.let {
        return it
    }
    title?.let {
        return it
    }
    return EMPTY_STRING
}

fun HitDomain.getUrl(): String {
    url?.let {
        return it
    }
    story_url?.let {
        return it
    }

    return EMPTY_STRING
}