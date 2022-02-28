package com.toch.algoliaapp.data.remote.repo_ser.api_service.repository

import com.toch.algoliaapp.data.remote.dto.toDomain
import com.toch.algoliaapp.data.remote.repo_ser.api_service.service.NewService
import com.toch.algoliaapp.model.HitDomain
import javax.inject.Inject

class NewRepositoryImpl @Inject constructor(
    private val newService: NewService
): NewRepository {

    override suspend fun getData(): List<HitDomain> = newService.getData().hits.map { it.toDomain() }


//    override suspend fun getMovieTrailer(page: Int): DataState<List<MovieTrailersDomain>>{
//        val data = service.getTrailerMovies(page)
//        return if (data.isSuccessful){
//            DataState.data(data.body()?.toDomain()?.results)
//        }else{
//            DataState.errorData(if (data.errorBody() != null) data.errorBody()!!.toErrorEntity() else ErrorEntity() )
//        }
//    }
}