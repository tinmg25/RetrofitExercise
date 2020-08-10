package com.tmw.retrofitexercise.api

import com.tmw.retrofitexercise.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiQueen {
    @GET("queen")
    fun getPost2(): Call<ArrayList<QueenItem>>
}