package kr.co.mbest.caloriexmldatapractice.data

import com.example.apipractice.json.Item
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Items(
    @Element(name = "item")
    val item: List<Item>
)
