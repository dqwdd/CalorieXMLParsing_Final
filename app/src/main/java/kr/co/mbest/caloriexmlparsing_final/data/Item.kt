package com.example.apipractice.json

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item (

    @PropertyElement(name="ANIMAL_PLANT")
    val ANIMAL_PLANT: String,

    @PropertyElement(name="BGN_YEAR")
    val BGN_YEAR: String,

    @PropertyElement(name="DESC_KOR")
    val DESC_KOR: String,

    @PropertyElement(name="NUTR_CONT1")
    val NUTR_CONT1: String,

    @PropertyElement(name="NUTR_CONT2")
    val NUTR_CONT2: String,

    @PropertyElement(name="NUTR_CONT3")
    val NUTR_CONT3: String,

    @PropertyElement(name="NUTR_CONT4")
    val NUTR_CONT4: String,

    @PropertyElement(name="NUTR_CONT5")
    val NUTR_CONT5: String,

    @PropertyElement(name="NUTR_CONT6")
    val NUTR_CONT6: String,

    @PropertyElement(name="NUTR_CONT7")
    val NUTR_CONT7: String,

    @PropertyElement(name="NUTR_CONT8")
    val NUTR_CONT8: String,

    @PropertyElement(name="NUTR_CONT9")
    val NUTR_CONT9: String,

    @PropertyElement(name="SERVING_WT")
    val SERVING_WT: String
)