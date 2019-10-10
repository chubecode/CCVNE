package com.chubecode.ccvne.ui.detail

import androidx.databinding.ViewDataBinding
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.ui.base.BaseFragment

import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewerFragment : BaseFragment<ViewDataBinding, ViewerViewModel>() {
    override val bindingVariable = BR.viewModel
    override val viewModel: ViewerViewModel by viewModel()
    override val layoutId = R.layout.viewer_fragment

}
