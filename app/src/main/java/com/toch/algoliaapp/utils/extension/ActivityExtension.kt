package com.toch.algoliaapp.utils.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> AppCompatActivity.collectLastLifecycleFLow(flow: Flow<T>, collect: suspend (T) -> Unit){
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            flow.collect(collect)
        }
    }
}