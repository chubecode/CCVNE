package com.chubecode.ccvne.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chubecode.ccvne.data.model.News
import com.chubecode.ccvne.data.repository.NewsRepository
import com.chubecode.ccvne.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NewsViewModel constructor(
    val repository: NewsRepository
) : BaseViewModel() {
    val news = MutableLiveData<MutableList<News>>()

    fun fetchNews() {
        viewModelScope.launch {
            news.value = repository.fetchRss()

        }
    }

}
