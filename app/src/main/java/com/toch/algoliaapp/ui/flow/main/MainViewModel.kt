package com.toch.algoliaapp.ui.flow.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toch.algoliaapp.data.cache.entities.toDomain
import com.toch.algoliaapp.data.repository.HitRepository
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.model.state.ListNewState
import com.toch.algoliaapp.model.toRoom
import com.toch.algoliaapp.utils.data.orGenericError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: HitRepository
): ViewModel() {

    private val _state = MutableStateFlow<ListNewState>(ListNewState.Resume)
    val state = _state.asStateFlow()

    private val _cacheData = MutableStateFlow<List<HitDomain>?>(null)
    val cacheData = _cacheData.asStateFlow()

    fun getHit() {
        viewModelScope.launch {
            repository.ucGetHit.invoke().collect {
                _state.value = when {
                    it.isLoading -> ListNewState.Loading
                    it.data != null -> {
                        deleteCacheHit()
                        saveHits(it.data)
                        ListNewState.SuccessData
                    }
                    else -> ListNewState.Error(it.error.orGenericError())
                }
            }
        }
    }

    fun getCacheHit(){
        viewModelScope.launch {
            _cacheData.value = repository.ucGetData.invoke()
        }
    }

    fun deleteCacheHit(hit: HitDomain, position: Int, delete: ( Int) -> Unit){
        viewModelScope.launch {
            repository.ucDeleteData.invoke(hit.toRoom())
            delete.invoke(position)
        }
    }

    private fun deleteCacheHit(){
        viewModelScope.launch {
            repository.ucDeleteData.invoke()
        }
    }

    private fun saveHits(hits: List<HitDomain>){
        viewModelScope.launch {
            repository.ucAddData.invoke(hits.map { it.toRoom() })
            getCacheHit()
        }
    }

}