package com.chubecode.ccvne.data.repository

import com.chubecode.ccvne.data.model.News
import com.chubecode.ccvne.data.remote.ApiService


class NewsRepository constructor(
    private val api: ApiService
) : BaseRepository() {


    suspend fun fetchRss(): MutableList<News> {
        return api.getRss().channel.item?.toMutableList()?: mutableListOf()
    }

}