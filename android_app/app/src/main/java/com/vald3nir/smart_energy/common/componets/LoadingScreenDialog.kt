//package com.vald3nir.smart_energy.common.componets
//
//import android.app.Dialog
//import android.content.Context
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.view.Window
//import com.vald3nir.smart_energy.R
//
//class LoadingScreenDialog(context: Context) :
//    Dialog(context, R.style.full_screen_dialog) {
//
//    init {
//        setCancelable(true)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val binding = CustomLoadingScreenBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.apply {
//            loading.showLoadingAnimation()
//            loading.setOnClickListener {
//                dismiss()
//            }
//        }
//
//    }
//
//
//}