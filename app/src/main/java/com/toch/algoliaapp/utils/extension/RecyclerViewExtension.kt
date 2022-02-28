package com.toch.algoliaapp.utils.extension

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.toch.algoliaapp.R
import com.toch.algoliaapp.utils.helper.SwipeHelper

fun RecyclerView.setupItemTouch(action: (Int) -> Unit){
    ItemTouchHelper(object : SwipeHelper(this) {
        override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> = listOf(deleteButton(position, this@setupItemTouch.context, action))
    }).apply {
        attachToRecyclerView(this@setupItemTouch)
    }
}

private fun deleteButton(position: Int, context: Context, action: (Int) -> Unit) =
     SwipeHelper.UnderlayButton(
        context,
         context.getString(R.string.delete),
        14.0f,
        android.R.color.holo_red_light,
        object : SwipeHelper.UnderlayButtonClickListener {
            override fun onClick() {
                action.invoke(position)
            }
        }
    )
