package com.chubecode.ccvne.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Root(name = "channel",strict = false)
data class Channel(
    @Element
    val title: String,

    @Element(name = "description")
    val description: String,

    @Element(name = "pubDate")
    val pubDate: String,

    @Element(name = "generator")
    val generator: String,

    @Element(name = "link")
    val link: String,

    @ElementList(inline = true,name = "item",required = false)
    val item: List<News>

):Serializable