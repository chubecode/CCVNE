package com.chubecode.ccvne.ui.news

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.data.model.AppColor
import com.chubecode.ccvne.ui.base.BaseFragment
import com.chubecode.ccvne.ui.main.MainViewModel
import com.chubecode.ccvne.utils.PreCachingLayoutManager
import kotlinx.android.synthetic.main.news_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<ViewDataBinding, NewsViewModel>() {
    override val bindingVariable = BR.viewModel
    override val viewModel: NewsViewModel by viewModel()
    override val layoutId = R.layout.news_fragment

    val mainViewModel: MainViewModel by sharedViewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initContent()

    }

    private fun initContent() {
        val adapter = NewsAdapter {
            val action = NewsFragmentDirections.actionNewsFragmentToViewerFragment(it.link ?: "")
            Navigation.findNavController(parent_view).navigate(action)
        }

        swipeContainer.setOnRefreshListener {
            viewModel.fetchNews()
        }
        viewBinding.get()?.apply {

            recycle_news.apply {
                layoutManager = PreCachingLayoutManager(context, RecyclerView.VERTICAL, false)
                setItemViewCacheSize(20)
                this.adapter = adapter
            }
        }

        viewModel.apply {
            //observer data here
            setAppColor(AppColor(Color.BLACK, Color.WHITE))
            fetchNews()
            news.observe(viewLifecycleOwner, Observer {
                swipeContainer.isRefreshing = false
                if (it.size > 0) {
                    adapter.submitList(it)
                }
            })

        }

        activity?.let {
            mainViewModel.color.observe(viewLifecycleOwner,
                Observer {
                    viewModel.setAppColor(appColor = it)
                })
        }
    }
}
