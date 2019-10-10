package com.chubecode.ccvne.ui.news

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chubecode.ccvne.BR
import com.chubecode.ccvne.R
import com.chubecode.ccvne.ui.base.BaseFragment
import com.chubecode.ccvne.utils.PreCachingLayoutManager
import kotlinx.android.synthetic.main.news_fragment.*

import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<ViewDataBinding, NewsViewModel>() {
    override val bindingVariable = BR.viewModel
    override val viewModel: NewsViewModel by viewModel()
    override val layoutId = R.layout.news_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initContent()

    }

    private fun initContent() {
        val adapter = NewsAdapter {
            val action = NewsFragmentDirections.actionNewsFragmentToViewerFragment()
            Navigation.findNavController(parent_view).navigate(action)
        }
        adapter.setHasStableIds(true)
        viewBinding.get()?.apply {

            recycle_news.apply {
                layoutManager = PreCachingLayoutManager(context, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
                setItemViewCacheSize(20)
                this.adapter = adapter
            }
        }

        viewModel.apply {

            fetchNews()
            news.observe(viewLifecycleOwner, Observer {
                if (it.size > 0) {
                    adapter.submitList(it)
                }
            })

        }
    }
}
