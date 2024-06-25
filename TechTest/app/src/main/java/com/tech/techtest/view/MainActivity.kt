package com.tech.techtest.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.tech.techtest.ui.composable.MovieList
import com.tech.techtest.ui.theme.TechTestTheme
import com.tech.techtest.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MovieList(mainViewModel)
                }
            }
        }
    }
}

