package com.toch.algoliaapp.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.toch.algoliaapp.R

class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout (context, attrs, defStyleAttr){

//    //GET VIEW FOR VIEWBINDING
    private val progressBar = ProgressBar(context).also {

    }

    init{
        val layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        layoutParams.width = 90
        layoutParams.height = 90
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhiteTransparent))
        addView(progressBar, layoutParams)
    }

    fun setState(state: Boolean) {
        if (state) {
            showProgressBar()
        } else {
            hideProgressBar()
        }
    }

    private fun showProgressBar() {
        this.isVisible = true
        progressBar.isVisible = true
    }

    private fun hideProgressBar() {
        this.isVisible = false
        progressBar.isVisible = false
    }

}