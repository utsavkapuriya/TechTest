package com.tech.techtest.domain.repository

import com.tech.techtest.data.source.Resource
import com.tech.techtest.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
}