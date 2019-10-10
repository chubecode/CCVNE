package com.chubecode.ccvne.ui.main

import android.os.Bundle
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.databinding.ActivityMainBinding
import com.chubecode.ccvne.ui.base.BaseActivity

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val bindingVariable: Int
        get() = BR.viewModel
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_main)


        viewModel.apply {
            //observer data here
        }
    }


}
