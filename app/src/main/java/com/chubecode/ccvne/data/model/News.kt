package com.chubecode.ccvne.data.model


import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import java.io.Serializable

/**
 * Created by ChuTien on ${1/25/2017}.
 */
@Xml(name = "item")
data class News(
    @PropertyElement(name = "title")
    val title: String? = null,

    @PropertyElement(writeAsCData = true)
    val description: String? = null,

    @PropertyElement(name = "pubDate")
    val pubDate: String? = null,

    @PropertyElement(name = "link")
    val link: String? = null,

    @PropertyElement(name = "guid")
    val guid: String? = null


) : Serializable


