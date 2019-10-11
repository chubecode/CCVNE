package com.chubecode.ccvne.data.model


import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Root(name = "item")
data class News(
    @Element(name = "title", required = false)
    val title: String? = null,

    @Element(name = "description", required = false)
    val description: String? = null,

    @Element(name = "pubDate", required = false)
    val pubDate: String? = null,

    @Element(name = "link", required = false)
    val link: String? = null,

    @Element(name = "guid", required = false)
    val guid: String? = null,

    @Element(name = "slash", required = false)
    val slash: String? = null,

    @Element(name = "comments", required = false)
    val comments: String? = null
)