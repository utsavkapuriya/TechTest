package com.tech.techtest.di

import com.tech.techtest.domain.repository.MovieRepository
import com.tech.techtest.domain.usecase.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MoviesUseCaseModule {

    @Provides
    @Singleton
    fun getMovieUseCase(repository: MovieRepository): GetMovies =
        GetMovies(repository)
}