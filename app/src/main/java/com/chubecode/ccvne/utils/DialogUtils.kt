package com.chubecode.ccvne.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.chubecode.ccvne.R

object DialogUtils {
    fun createLoadingDialog(
        context: Context?, cancelable: Boolean = false,
        canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        return AlertDialog.Builder(context)
            .setView(R.layout.layout_dialog_process)
            .create().apply {
                setCancelable(cancelable)
                setCanceledOnTouchOutside(canceledOnTouchOutside)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
    }

    fun showMessage(
        context: Context?, title: String? = null, message: String? = null,
        textPositive: String? = null, positiveListener: (() -> Unit)? = null,
        textNegative: String? = null, negativeListener: (() -> Unit)? = null,
        cancelable: Boolean = false, canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        return AlertDialog.Builder(context).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton(textPositive) { _, _ ->
                positiveListener?.invoke()
            }
            setNegativeButton(textNegative) { _, _ ->
                negativeListener?.invoke()
            }
            setCancelable(cancelable)

        }.create().apply {
            setCanceledOnTouchOutside(canceledOnTouchOutside)
            show()
        }
    }
}