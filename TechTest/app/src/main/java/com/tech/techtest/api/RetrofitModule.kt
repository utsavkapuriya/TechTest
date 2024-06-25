package com.tech.techtest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = "https://howtodoandroid.com/apis/"

    private val provideRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val provideApiService: RetrofitService by lazy {
        provideRetrofit.create(RetrofitService::class.java)
    }

}