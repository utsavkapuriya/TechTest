package com.tech.techtest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val retrofitService = RetrofitService.getInstance()
            try {
                val movieList = retrofitService.getMovies()
                movieListResponse = movieList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}