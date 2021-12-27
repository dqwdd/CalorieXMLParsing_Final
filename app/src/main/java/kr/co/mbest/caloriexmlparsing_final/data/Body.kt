package com.example.apipractice.json

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import kr.co.mbest.caloriexmldatapractice.data.Items

@Xml(name = "body")
data class Body(

    @Element
    val items: Items,
    //val items: List<Item>,

    @PropertyElement
    val numOfRows: Int,

    @PropertyElement
    val pageNo: Int,

    @PropertyElement
    val totalCount: Int

)