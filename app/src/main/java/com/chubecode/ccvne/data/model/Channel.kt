package com.chubecode.ccvne.data.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import java.io.Serializable

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Xml(name = "channel")
data class Channel(
    @PropertyElement(name = "title")
    val title: String,

    @PropertyElement(name = "description")
    val description: String,

    @PropertyElement(name = "pubDate")
    val pubDate: String,

    @PropertyElement(name = "generator")
    val generator: String,

    @PropertyElement(name = "link")
    val link: String,

    @Element(name = "item")
    val item: List<News>?=null

) : Serializable