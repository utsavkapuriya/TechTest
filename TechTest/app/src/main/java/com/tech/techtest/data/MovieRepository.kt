package com.tech.techtest.data

import com.tech.techtest.api.RetrofitService
import com.tech.techtest.model.Movie
import javax.inject.Inject


class MovieRepository @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getMovies(): List<Movie> {
        return retrofitService.getMovies()
    }
}
