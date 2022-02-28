package com.toch.algoliaapp.model.state

import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.utils.data.ErrorDomain

sealed class ListNewState {
    object Loading: ListNewState()
    object Resume: ListNewState()
    object SuccessData: ListNewState()
    data class Error(val error: ErrorDomain): ListNewState()
}