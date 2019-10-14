package com.chubecode.ccvne.ui.news

import android.graphics.Color
import androidx.recyclerview.widget.DiffUtil
import com.chubecode.ccvne.R
import com.chubecode.ccvne.data.model.AppColor
import com.chubecode.ccvne.data.model.News
import com.chubecode.ccvne.databinding.ItemNewsBinding
import com.chubecode.ccvne.ui.base.BaseRecyclerAdapter

class NewsAdapter(
    private val itemClickListener: ((News) -> Unit)? = null
) : BaseRecyclerAdapter<News, ItemNewsBinding>(object : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}) {
    var appColor: AppColor = AppColor(Color.BLACK,Color.WHITE)



    override fun getLayoutRes(viewType: Int): Int {
        return R.layout.item_news
    }

    override fun bindFirstTime(binding: ItemNewsBinding) {
        binding.apply {
            //handler click event here

        }
    }

    override fun bindView(binding: ItemNewsBinding, item: News) {
        binding.apply {
            this.item = item
            //handler something with item
            this.color = appColor

            this.lytParent.setOnClickListener {
                item.apply {
                    itemClickListener?.invoke(this)
                }
            }

        }
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).hashCode().toLong()
    }

}
