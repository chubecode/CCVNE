package com.chubecode.ccvne.data.remote.response

import com.chubecode.ccvne.data.model.Channel
import com.chubecode.ccvne.data.model.News
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Root(name = "rss", strict = false)
class ListNewsResponse(
    @Element
    val channel: Channel? = null

)