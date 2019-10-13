package com.chubecode.ccvne.utils

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.databinding.BindingAdapter


@SuppressLint("ObsoleteSdkInt")
@BindingAdapter("setWebViewClient")
fun WebView.setWebViewClient(client: WebChromeClient) {
    webChromeClient = client
    if (Build.VERSION.SDK_INT < 19) {
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
    } else {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    settings.javaScriptEnabled = true
    settings.loadWithOverviewMode = true
    settings.useWideViewPort = true
    settings.setSupportZoom(true)
    settings.builtInZoomControls = false
    settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
    settings.cacheMode = WebSettings.LOAD_NO_CACHE
    settings.domStorageEnabled = true

}

@BindingAdapter("loadUrl")
fun WebView.loadUrl(url: String?) {
    if (url != null) {
        loadUrl(url)
    }
}