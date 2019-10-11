package com.chubecode.ccvne.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Root(name = "channel")
data class Channel(
    @Element(name = "title")
    val title: String? = null,

    @Element(name = "description")
    val description: String? = null,

    @Element(name = "pubDate")
    val pubDate: String? = null,

    @Element(name = "generator")
    val generator: String? = null,

    @Element(name = "link")
    val link: String? = null,

    @ElementList(inline = true)
    val item: List<News>? = null

)