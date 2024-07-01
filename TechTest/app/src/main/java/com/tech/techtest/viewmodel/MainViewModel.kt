package com.tech.techtest.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.techtest.data.MovieRepository
import com.tech.techtest.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository): ViewModel() {
    private val _moviesData = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _moviesData

    private var errorMessage: String by mutableStateOf("")

    fun getMovieList() {
        viewModelScope.launch {
            try {
                val movie = movieRepository.getMovies()
                _moviesData.value = movie
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}