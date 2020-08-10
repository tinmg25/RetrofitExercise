package com.tmw.retrofitexercise.api

import com.tmw.retrofitexercise.model.KingItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiKing {
    @GET("king")
    fun getPost1(): Call<ArrayList<KingItem>>
}