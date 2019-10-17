package com.chubecode.ccvne.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d("Tien-Activity", "onCreate")
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        Log.d("Tien-Activity", "onDestroy")
        super.onDestroy()
    }

    override fun onStart() {
        Log.d("Tien-Activity", "onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.d("Tien-Activity", "onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.d("Tien-Activity", "onResume")
        super.onResume()

    }

    override fun onPause() {
        Log.d("Tien-Activity", "onPause")

        super.onPause()
    }

    override fun onStop() {
        Log.d("Tien-Activity", "onStop")
        super.onStop()
    }


}