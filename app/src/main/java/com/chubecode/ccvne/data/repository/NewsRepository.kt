package com.chubecode.ccvne.data.repository

import com.chubecode.ccvne.data.model.News
import com.chubecode.ccvne.data.remote.ApiService

class NewsRepository constructor(
    private val api: ApiService
) : BaseRepository() {


    suspend fun callRss() = safeApiCall(
        call = { api.getRss().await() },
        errorMessage = "Error get Rss"
    )

    suspend fun fetchRss(): MutableList<News> = callRss()?.news?.toMutableList() ?: mutableListOf()
}