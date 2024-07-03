package com.tech.techtest.di

import com.tech.techtest.data.repository.MovieRepositoryImpl
import com.tech.techtest.data.source.MovieApiService
import com.tech.techtest.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MoviesRepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepositoryImpl(
        movieApiService: MovieApiService,
    ): MovieRepository = MovieRepositoryImpl(movieApiService)

}