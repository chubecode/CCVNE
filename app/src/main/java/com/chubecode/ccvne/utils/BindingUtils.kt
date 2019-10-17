package com.chubecode.ccvne.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Switch
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chubecode.ccvne.data.model.AppColor
import com.chubecode.ccvne.ui.base.BaseViewModel
import com.chubecode.ccvne.ui.news.NewsAdapter
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.viewer_fragment.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("ObsoleteSdkInt")
@BindingAdapter("setWebViewClient")
fun WebView.setWebViewClient(client: WebChromeClient) {
    webViewClient = object : WebViewClient() {


        override fun onPageFinished(view: WebView?, url: String?) {
            loadUrl(
                "javascript:document.body.style.setProperty(\"color\", \"red\");"
            )
        }
    }
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



@BindingAdapter("app:imageUrl")
fun loadImage(view: SimpleDraweeView, content: String?) {
    if (content != null) {
        val url = content.substringAfter("src=\"").substringBefore("\"")
        if (!url.isEmpty()) {
            view.setImageURI(url)
        }
    }

}

@BindingAdapter("app:description")
fun loadText(view: TextView, content: String?) {
    if (content != null) {
        val description = content.substringAfter("br>").substringBefore(".\"")
        if (!description.isEmpty()) {
            view.text = description
        }
    }

}

@BindingAdapter("app:color")
fun loadColor(view: RecyclerView, color: AppColor?) {
    if (color != null) {
        if (view.adapter is NewsAdapter) {
            (view.adapter as NewsAdapter).appColor = color
            (view.adapter as NewsAdapter).notifyDataSetChanged()
        }

    }

}

@BindingAdapter("app:date")
fun loadDate(view: TextView, content: String?) {

    try {
        val simpleDateFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
        val date = simpleDateFormat.parse(content)
        val format = SimpleDateFormat("HH:mm:ss, EEE dd/MM/yyyy", Locale("vi"))
        view.text = format.format(date)
    } catch (e: Exception) {
        view.text = content
    }


}

@BindingAdapter("app:darkmode")
fun setDarkMode(view: Switch, viewModel: BaseViewModel?) {
    if (viewModel != null) {
        view.setOnCheckedChangeListener { _, isDarkMode ->

            viewModel.apply {
                //observer data here
                setAppColor(
                    if (!isDarkMode) AppColor(Color.BLACK, Color.WHITE) else AppColor(
                        Color.WHITE,
                        Color.BLACK
                    )
                )
            }

        }

    }

}