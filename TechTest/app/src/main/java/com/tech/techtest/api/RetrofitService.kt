package com.tech.techtest.api

import com.tech.techtest.model.Movie
import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>
}