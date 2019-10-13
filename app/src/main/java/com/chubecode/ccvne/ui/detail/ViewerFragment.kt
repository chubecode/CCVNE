package com.chubecode.ccvne.ui.detail

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.ui.base.BaseFragment
import com.chubecode.ccvne.ui.main.MainViewModel
import kotlinx.android.synthetic.main.viewer_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ViewerFragment : BaseFragment<ViewDataBinding, ViewerViewModel>() {
    private val args: ViewerFragmentArgs by navArgs()
    override val bindingVariable = BR.viewModel
    override val viewModel: ViewerViewModel by viewModel()
    override val layoutId = R.layout.viewer_fragment

    val mainViewModel: MainViewModel by sharedViewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.get()?.apply {
            setVariable(BR.url, args.url)
        }
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.setSupportZoom(true)
        settings.builtInZoomControls = false
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.domStorageEnabled = true

        activity?.let {
            mainViewModel.color.observe(viewLifecycleOwner,
                Observer {
                    viewModel.setAppColor(appColor = it)
                    web_view.loadUrl(
                        "javascript:document.body.style.setProperty(\"color\", \"" + String.format(
                            "#%06X",
                            0xFFFFFF and it.textColor
                        ) + "\");"
                    )
                    web_view.loadUrl(
                        "javascript:document.body.style.setProperty(\"background\", \"" + String.format(
                            "#%06X",
                            0xFFFFFF and it.bgColor
                        ) + "\");"
                    )

                })
        }
    }
}
