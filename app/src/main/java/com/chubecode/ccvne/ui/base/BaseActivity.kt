package com.chubecode.ccvne.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<ActivityBinding : ViewDataBinding, ViewModel : BaseViewModel> : AppCompatActivity() {
    abstract val bindingVariable: Int

    lateinit var binding: ActivityBinding

    abstract val viewModel: ViewModel

    protected fun bindView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setLifecycleOwner { this.lifecycle }
        binding.apply {
            setVariable(bindingVariable, viewModel)
        }
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        super.onDestroy()
    }
}