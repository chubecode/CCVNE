package com.chubecode.ccvne.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chubecode.ccvne.data.model.News

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class MainViewModel  : ViewModel(){
    private val news: MutableLiveData<List<News>> by lazy {
        MutableLiveData<List<News>>().also{
                loadRss()
        }
    }

    fun getNews() : LiveData<List<News>>{
        return news
    }

    private fun loadRss(){

    }
}