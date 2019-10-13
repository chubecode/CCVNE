package com.chubecode.ccvne.data.repository

import androidx.lifecycle.MutableLiveData
import com.chubecode.ccvne.data.model.News
import com.chubecode.ccvne.data.remote.ApiService
import com.chubecode.ccvne.data.remote.response.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsRepository constructor(
    private val api: ApiService
) : BaseRepository() {


    suspend fun fetchRss(): MutableLiveData<MutableList<News>> {
        val newsData = MutableLiveData<MutableList<News>>()

//        api.getRss().enqueue(object : Callback<Rss> {
//
//            override fun onResponse(
//                call: Call<Rss>,
//                response: Response<Rss>
//            ) {
//                if (response.isSuccessful) {
//                    newsData.value = response.body()?.channel?.item?.toMutableList() ?: mutableListOf()
//                }
//            }
//
//            override fun onFailure(call: Call<Rss>, t: Throwable) {
//                newsData.value = null
//            }
//        })
        return newsData
    }
}