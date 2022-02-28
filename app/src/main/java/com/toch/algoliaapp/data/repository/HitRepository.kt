package com.toch.algoliaapp.data.repository

import com.toch.algoliaapp.data.cache.use_case.UCAddData
import com.toch.algoliaapp.data.cache.use_case.UCDeleteData
import com.toch.algoliaapp.data.cache.use_case.UCGetData
import com.toch.algoliaapp.data.remote.use_case.UCGetHit
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HitRepository @Inject constructor(
    val ucGetHit: UCGetHit,
    val ucGetData: UCGetData,
    val ucDeleteData: UCDeleteData,
    val ucAddData: UCAddData
)