package com.chubecode.ccvne.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
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
        Log.d("Tien-" + this.javaClass.simpleName, "onCreateView")
        val dataBinding: ViewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding = AutoClearedValue(this, dataBinding)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Tien-" + this.javaClass.simpleName, "onViewCreated")
        viewBinding.get()?.apply {
            lifecycleOwner = this@BaseFragment.viewLifecycleOwner
            setVariable(bindingVariable, viewModel)
            root.isClickable = true
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Tien-" + this.javaClass.simpleName, "onActivityCreated")
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

    override fun onAttach(context: Context) {
        Log.d("Tien-" + this.javaClass.simpleName, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Tien-" + this.javaClass.simpleName, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Tien-" + this.javaClass.simpleName, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Tien-" + this.javaClass.simpleName, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Tien-" + this.javaClass.simpleName, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Tien-" + this.javaClass.simpleName, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Tien-" + this.javaClass.simpleName, "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d("Tien-" + this.javaClass.simpleName, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Tien-" + this.javaClass.simpleName, "onDetach")
        super.onDetach()
    }

}