package com.tmw.retrofitexercise.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiKingClient {
    private val BASE_URL1 = "https://ucsmonywaonlinevote.000webhostapp.com/api/"

    private var retrofit1: Retrofit? = null

    init {
        if (retrofit1 == null) {
            retrofit1 = Retrofit.Builder().baseUrl(BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

    val kingApiService=retrofit1!!.create(ApiKing::class.java)
}