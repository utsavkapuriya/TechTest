package com.tech.techtest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.techtest.data.source.Resource
import com.tech.techtest.domain.usecase.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movies: GetMovies
) : ViewModel() {

    private val _state = mutableStateOf(MovieUiState())
    val state: State<MovieUiState> = _state

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {

            movies().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            moviesList = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            moviesList = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            moviesList = result.data ?: emptyList(),
                            isLoading = false
                        )

                    }
                }
            }.launchIn(this)
        }
    }
}