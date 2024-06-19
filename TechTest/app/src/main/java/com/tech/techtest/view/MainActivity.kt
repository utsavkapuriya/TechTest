package com.tech.techtest.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.tech.techtest.viewmodel.MainViewModel
import com.tech.techtest.ui.composable.MovieList
import com.tech.techtest.ui.theme.TechTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MovieList(movieList = mainViewModel.movieListResponse)
                    mainViewModel.getMovieList()
                }
            }
        }
    }
}

