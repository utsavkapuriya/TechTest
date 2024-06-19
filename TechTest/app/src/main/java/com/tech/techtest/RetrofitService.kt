package com.tech.techtest

import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>

//    companion object {
//        private var retrofitService: RetrofitService? = null
//        fun getInstance() : RetrofitService {
//            if (retrofitService == null) {
//                retrofitService = Retrofit.Builder()
//                    .baseUrl("https://howtodoandroid.com/apis/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                .build().create(RetrofitService::class.java)
//            }
//            return retrofitService!!
//        }
//    }
}