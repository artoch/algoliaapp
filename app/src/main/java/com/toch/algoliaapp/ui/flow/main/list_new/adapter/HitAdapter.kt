package com.toch.algoliaapp.ui.flow.main.list_new.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toch.algoliaapp.databinding.ItemNewBinding
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.model.getTitle
import com.toch.algoliaapp.utils.extension.dateToMinutes

class HitAdapter (private var items: MutableList<HitDomain> = mutableListOf(), private val action: (HitDomain) -> Unit) : RecyclerView.Adapter<HitAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items : List<HitDomain>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getItem(position: Int) = items[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  = ViewHolder(
        ItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], action)
    }

    override fun getItemCount(): Int = items.size
    class ViewHolder(private val itemBinding: ItemNewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: HitDomain, action: (HitDomain) -> Unit) {
            itemBinding.apply {
                tvTitle.text = item.getTitle()
                val authTime = "${item.author} - ${item.created_at.dateToMinutes()}"
                tvAuthor.text = authTime
                cvItem.setOnClickListener {
                    action.invoke(item)
                }

            }
        }
    }

}