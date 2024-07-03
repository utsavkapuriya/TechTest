package com.tech.techtest.presentation.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tech.techtest.presentation.viewmodel.MoviesViewModel

@Composable
fun MovieListScreen(moviesViewModel: MoviesViewModel = hiltViewModel()) {

    val state = moviesViewModel.state.value

    var selectedIndex by remember { mutableIntStateOf(-1) }

    state.moviesList.let {
        LazyColumn(
            Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            itemsIndexed(items = it) { index, item ->
                MovieItem(movie = item, index, selectedIndex) { i ->
                    selectedIndex = i
                }
            }
        }
    }
}