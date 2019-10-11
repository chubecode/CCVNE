package com.chubecode.ccvne.data.remote

import com.chubecode.ccvne.data.remote.response.ListNewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by ChuTien on ${1/25/2017}.
 */
interface ApiService {

    @GET("rss/tin-moi-nhat.rss")
    suspend fun getRss(): Deferred<Response<ListNewsResponse>>
}