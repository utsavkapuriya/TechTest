package com.tech.techtest.data.repository

import com.tech.techtest.data.source.MovieApiService
import com.tech.techtest.data.source.Resource
import com.tech.techtest.domain.model.Movie
import com.tech.techtest.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MovieRepositoryImpl constructor(
    private val movieApiService: MovieApiService,
) : MovieRepository {

    override fun getMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(movieApiService.getMovies()))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        }
    }
}