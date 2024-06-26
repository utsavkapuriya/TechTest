package com.tech.techtest.ui.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tech.techtest.viewmodel.MainViewModel

@Composable
fun MovieList(viewModel: MainViewModel) {
    val usersState by viewModel.movieList.observeAsState()
    val error by viewModel.errorMessage.observeAsState(initial = "No Records found")
    LaunchedEffect(Unit) {
        viewModel.getMovieList()
    }
    var selectedIndex by remember { mutableIntStateOf(-1) }
    usersState?.let {
        LazyColumn {
            itemsIndexed(items = it) { index, item ->
                MovieItem(movie = item, index, selectedIndex) { i ->
                    selectedIndex = i
                }
            }
        }
    } ?: ErrorMessage(displayText = error)
}