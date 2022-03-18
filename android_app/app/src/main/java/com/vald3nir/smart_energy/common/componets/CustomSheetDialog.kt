package com.vald3nir.smart_energy.common.componets

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.vald3nir.smart_energy.databinding.CustomItemListBinding
import com.vald3nir.smart_energy.databinding.CustomSheetDialogBinding

class CustomSheetDialog(context: Context, private val items: List<CustomItemSheet>) :
    BottomSheetDialog(context) {

    init {
        setCancelable(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CustomSheetDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.rvItems.apply {
            adapter = SheetDialogAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }

    inner class SheetDialogAdapter() :
        RecyclerView.Adapter<ViewHolder>() {

//        private val items = listOf(
//            CustomItemSheet(title = "item", action = {}),
//            CustomItemSheet(title = "item", action = {}),
//            CustomItemSheet(title = "item", action = {}),
//            CustomItemSheet(title = "item", action = {}),
//            CustomItemSheet(title = "item", action = {}),
//            CustomItemSheet(title = "item", action = {}),
//        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(CustomItemListBinding.inflate(layoutInflater))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindView(items[position])
        }

        override fun getItemCount(): Int = items.size
    }

    inner class ViewHolder(itemView: CustomItemListBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        fun bindView(item: CustomItemSheet) {
            itemView.apply {
                setOnClickListener { item.action.invoke() }
            }
        }
    }

    data class CustomItemSheet(
        val title: String,
        val action: () -> Unit
    )

}