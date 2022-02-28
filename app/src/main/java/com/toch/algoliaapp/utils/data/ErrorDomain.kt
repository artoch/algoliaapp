package com.toch.algoliaapp.utils.data

import com.toch.algoliaapp.utils.EMPTY_STRING

abstract class ErrorDomain

data class ErrorEntity(
    val message: String = EMPTY_STRING,
    val code: String = EMPTY_STRING,
): ErrorDomain()