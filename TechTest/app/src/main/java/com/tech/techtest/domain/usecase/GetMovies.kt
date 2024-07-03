package com.tech.techtest.domain.usecase

import com.tech.techtest.data.source.Resource
import com.tech.techtest.domain.model.Movie
import com.tech.techtest.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> {
        return movieRepository.getMovies()
    }
}