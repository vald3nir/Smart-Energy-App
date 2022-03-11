package com.vald3nir.smart_energy.common.componets

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.vald3nir.smart_energy.databinding.CustomSheetDialogBinding

class CustomSheetDialog(context: Context) : BottomSheetDialog(context) {

    init {
        setCancelable(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = CustomSheetDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    inner class SheetDialogAdapter : RecyclerView.Adapter<ViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}