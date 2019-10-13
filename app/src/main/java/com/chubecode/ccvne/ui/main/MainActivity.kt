package com.chubecode.ccvne.ui.main

import android.graphics.Color
import android.os.Bundle
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.data.model.AppColor
import com.chubecode.ccvne.databinding.ActivityMainBinding
import com.chubecode.ccvne.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val bindingVariable: Int
        get() = BR.viewModel
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_main)


        sw_dark_mode.setOnCheckedChangeListener { _, isDarkMode ->
            viewModel.apply {
                //observer data here
                setAppColor(if (!isDarkMode) AppColor(Color.BLACK, Color.WHITE) else AppColor(Color.WHITE, Color.BLACK))
            }
        }
        viewModel.apply {
            //observer data here
            setAppColor(AppColor(Color.BLACK, Color.WHITE))
            binding.executePendingBindings()
        }


    }


}
