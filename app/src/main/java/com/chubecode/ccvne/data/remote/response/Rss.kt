package com.chubecode.ccvne.data.remote.response

import com.chubecode.ccvne.data.model.Channel
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Root(name = "rss", strict = false)
data class Rss(
    @Element
    val channel: Channel

) : Serializable