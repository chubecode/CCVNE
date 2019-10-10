package com.chubecode.ccvne.ui.base

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chubecode.ccvne.BR
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<Item, ViewBinding : ViewDataBinding>(
    callback: DiffUtil.ItemCallback<Item>
) : ListAdapter<Item, BaseViewHolder<ViewBinding>>(
    AsyncDifferConfig.Builder<Item>(callback)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding> {
        return BaseViewHolder(
            DataBindingUtil.inflate<ViewBinding>(
                LayoutInflater.from(parent.context),
                getLayoutRes(viewType),
                parent, false
            ).apply {
                bindFirstTime(this)
            }
        )

    }


    @SuppressLint("TimberArgCount")
    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding>, position: Int) {
        val item = getItem(position)
        holder.binding.setVariable(BR.item, item)
        bindView(holder.binding, item)
        holder.binding.executePendingBindings()
        Log.d("Tien", "onBindViewHolder")
    }

    /**
     * get layout res based on view type
     */
    protected abstract fun getLayoutRes(viewType: Int): Int

    /**
     * overide if need
     * bind first time
     * use for set item onClickListener, something only set on item
     */
    protected abstract fun bindFirstTime(binding: ViewBinding)

    /**
     * override if need
     * bind view
     */
    protected open fun bindView(binding: ViewBinding, item: Item) {}

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}


open class BaseViewHolder<ViewBinding : ViewDataBinding> constructor(
    val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root)