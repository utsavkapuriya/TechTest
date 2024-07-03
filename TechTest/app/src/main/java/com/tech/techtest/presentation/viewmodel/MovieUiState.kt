package com.tech.techtest.presentation.viewmodel

import com.tech.techtest.domain.model.Movie


data class MovieUiState(
    val moviesList: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)