package com.toch.algoliaapp.data.remote.dto

data class NewDto(
    val exhaustiveNbHits: Boolean,
    val exhaustiveTypo: Boolean,
    val hits: List<HitDto>,
    val hitsPerPage: Int,
    val nbHits: Int,
    val nbPages: Int,
    val page: Int,
    val params: String,
    val processingTimeMS: Int,
    val query: String
)