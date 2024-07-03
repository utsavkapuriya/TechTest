package com.tech.techtest.data.source

import com.tech.techtest.domain.model.Movie
import retrofit2.http.GET

interface MovieApiService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>
}