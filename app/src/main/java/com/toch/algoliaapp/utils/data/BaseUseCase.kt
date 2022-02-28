package com.toch.algoliaapp.utils.data

import com.toch.algoliaapp.utils.data.DataState.Companion.errorData
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase {

    protected fun <T> myFlow(
        action: suspend FlowCollector<DataState<T>>.() -> Unit
    ) = flow {
        try {
            this.action()
        } catch (e: Exception) {
            emit(errorData<T>(ErrorEntity(
                message = e.message.orEmpty()
            )))
        }
    }
}