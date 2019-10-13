package com.chubecode.ccvne.ui.detail

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.navArgs
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewerFragment : BaseFragment<ViewDataBinding, ViewerViewModel>() {
    private val args: ViewerFragmentArgs by navArgs()
    override val bindingVariable = BR.viewModel
    override val viewModel: ViewerViewModel by viewModel()
    override val layoutId = R.layout.viewer_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.get()?.apply {
            setVariable(BR.url,args.url)
        }
    }
}
