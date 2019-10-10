package com.chubecode.ccvne.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.chubecode.ccvne.R
import com.chubecode.ccvne.utils.AutoClearedValue
import com.chubecode.ccvne.utils.DialogUtils

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment() {

    abstract val bindingVariable: Int

    lateinit var viewBinding: AutoClearedValue<ViewBinding>

    abstract val viewModel: ViewModel

    @get:LayoutRes
    abstract val layoutId: Int

    var mAlertDialog: AlertDialog? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding: ViewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding = AutoClearedValue(this, dataBinding)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.get()?.apply {
            setVariable(bindingVariable, viewModel)
            root.isClickable = true
            lifecycleOwner = this@BaseFragment
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAlertDialog = DialogUtils.createLoadingDialog(context, false)
        viewModel.apply {
            isLoading.observe(this@BaseFragment, Observer {
                handleShowLoading(it)
            })
            errorMessage.observe(this@BaseFragment, Observer {
                handleShowErrorMessage(it)
            })
        }
    }

    open fun handleShowLoading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    fun showLoading() {
        hideLoading()
        mAlertDialog?.show()
    }

    fun hideLoading() {
        if (mAlertDialog != null && mAlertDialog!!.isShowing) {
            mAlertDialog?.cancel()
        }
    }

    private fun handleShowErrorMessage(message: String) {
        DialogUtils.showMessage(context, message = message, textPositive = getString(R.string.ok))
    }


}