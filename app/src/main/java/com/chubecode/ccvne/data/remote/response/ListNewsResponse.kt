package com.chubecode.ccvne.data.remote.response

import com.chubecode.ccvne.data.model.Feed
import com.chubecode.ccvne.data.model.News
import com.google.gson.annotations.SerializedName

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class ListNewsResponse (
    @SerializedName("feed") val feed : Feed? = null,
    @SerializedName("items") val news : List<News>? = null
)