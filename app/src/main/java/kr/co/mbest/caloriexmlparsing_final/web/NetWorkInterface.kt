package com.example.apipractice.web

import com.example.apipractice.json.Library
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface NetWorkInterface {

    @GET("/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList") //칼로리 조회 주소
    fun getRequestKcalList(
        @Query("ServiceKey", encoded = true) key: String,
        @Query("type") type: String="xml") : Call<Library>

}