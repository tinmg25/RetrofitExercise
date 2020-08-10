package com.tmw.retrofitexercise.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiQueenClient {
    private val BASE_URL2 = "https://ucsmonywaonlinevote.000webhostapp.com/api/"

    private var retrofit2: Retrofit? = null

    init {
        if (retrofit2 == null) {
            retrofit2 = Retrofit.Builder().baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

    val queenApiService=retrofit2!!.create(ApiQueen::class.java)
}