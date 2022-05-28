package com.vald3nir.smart_energy.common.componets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class GenericAdapter<Item, Binding : ViewBinding>(
    var bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
    var list: Collection<Item>,
    var onBind: (Item, Binding, Int, GenericAdapter<Item, Binding>) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            bindingInflater.invoke(LayoutInflater.from(parent.context), parent, false), this
        )
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = position

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GenericAdapter<*, *>.ViewHolder).bindItem(position)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    inner class ViewHolder(
        private val binding: Binding, private val genericAdapter: GenericAdapter<Item, Binding>
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(position: Int) {
            list.elementAt(position).apply {
                onBind.invoke(this, binding, position, genericAdapter)
            }
        }
    }
}
