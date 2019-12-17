package com.junemon.daggerinmitch.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.junemon.daggerinmitch.R
import com.junemon.daggerinmitch.helper.layoutInflater
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    private lateinit var alert: AlertDialog

    protected fun setBaseDialog(context: Context) {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_loading, null)
        dialogBuilder.setView(dialogView)
        alert = dialogBuilder.create()
        alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alert.setCancelable(false)
        alert.setCanceledOnTouchOutside(false)
    }

    protected fun setDialogShow(status: Boolean) {
        if (status) {
            alert.dismiss()
        } else {
            alert.show()
        }
    }
}