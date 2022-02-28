package com.toch.algoliaapp.data.remote.use_case

import com.toch.algoliaapp.data.remote.repo_ser.api_service.repository.NewRepository
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.utils.data.BaseUseCase
import com.toch.algoliaapp.utils.data.DataState
import com.toch.algoliaapp.utils.data.ErrorEntity
import javax.inject.Inject

class UCGetHit @Inject constructor(
    private val newRepository: NewRepository,
    //private val
) :BaseUseCase() {

    suspend operator fun invoke() = myFlow<List<HitDomain>>{
        emit(DataState.loading())
        val data = newRepository.getData()
        if (data.isNotEmpty()){
            emit(DataState.data(data))
        }else{
            emit(DataState.errorData(ErrorEntity()))
        }
    }

}