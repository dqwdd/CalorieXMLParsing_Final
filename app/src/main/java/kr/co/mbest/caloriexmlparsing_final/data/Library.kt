package com.example.apipractice.json

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml
import java.io.Serializable


@Xml(name = "response")
data class Library(

    @Element
    val body: Body,

    @Element
    val header: Header

) : Serializable


/*
data class Library(
    val body: Body,
    val header: Header
)
*/
