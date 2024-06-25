package com.tech.techtest.data

import com.tech.techtest.api.RetrofitModule
import com.tech.techtest.model.Movie


class MovieRepository {
    private val retrofitService = RetrofitModule.provideApiService

    suspend fun getMovies(): List<Movie> {
        return retrofitService.getMovies()
    }
}
