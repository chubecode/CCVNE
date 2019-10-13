package com.chubecode.ccvne.data.remote.response

import com.chubecode.ccvne.data.model.Channel
import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml
import java.io.Serializable

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Xml(name = "rss")
data class Rss(
    @Attribute(name="version")
    val version : String,
    @Element
    val channel: Channel

) : Serializable