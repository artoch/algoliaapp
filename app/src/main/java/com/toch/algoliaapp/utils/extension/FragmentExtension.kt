package com.toch.algoliaapp.utils.extension

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.model.getUrl
import com.toch.algoliaapp.ui.view.WebViewActivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun Fragment.openHitDialog(hit: HitDomain){
    if (hit.getUrl().isEmpty()){
        Toast.makeText(requireContext(), "No notice", Toast.LENGTH_SHORT).show()
    }else{
        val intent = Intent(activity, WebViewActivity::class.java).also {
            it.putExtra(WebViewActivity.URL, hit.getUrl())
        }
        startActivity(intent)
    }

}


fun <T> Fragment.collectLastLifecycleFLow(flow: Flow<T>, collect: suspend (T) -> Unit){
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            flow.collect(collect)
        }
    }
}