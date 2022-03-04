package com.vald3nir.smart_energy.common.core

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vald3nir.smart_energy.common.componets.LoadingScreenDialog

open class BaseActivity : AppCompatActivity(), AppView {

    private var toast: Toast? = null
    private var loadingScreenDialog: LoadingScreenDialog? = null

    override fun getActivityContext(): Activity? {
        return this
    }

    override fun showMessage(message: String?) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun showMessage(message: Int) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    override fun showLoading(show: Boolean) {
        if (show) {
            loadingScreenDialog?.dismiss()
            loadingScreenDialog = LoadingScreenDialog(this)
            loadingScreenDialog?.show()
        } else {
            loadingScreenDialog?.dismiss()
        }
    }
}