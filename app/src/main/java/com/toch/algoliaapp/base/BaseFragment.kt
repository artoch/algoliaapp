package com.toch.algoliaapp.base

import android.view.ViewGroup
import android.view.ViewManager
import androidx.fragment.app.Fragment
import com.toch.algoliaapp.model.state.ListNewState
import com.toch.algoliaapp.ui.view.ProgressView

abstract class BaseFragment : Fragment() {

    private var loadingBar: ProgressView? = null

    /**
     * Loading
     */

    private fun initLoading() {
        if (loadingBar == null) {
            loadingBar = ProgressView(requireContext())
            requireActivity().addContentView(
                loadingBar,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }else{
            removeLoading()
            initLoading()
        }
    }

    protected fun showLoading(showing: ListNewState) {
        initLoading()
        loadingBar?.setState(showing == ListNewState.Loading)
    }

    private fun removeLoading() {
        if (loadingBar != null) {
            val viewParent = loadingBar?.parent
            if (viewParent != null && viewParent is ViewManager) {
                (viewParent as ViewManager).removeView(loadingBar)
            }
        }
        loadingBar = null
    }

}