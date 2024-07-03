package com.tech.techtest.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.tech.techtest.presentation.ui.composable.MovieListScreen
import com.tech.techtest.presentation.ui.theme.TechTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MovieListScreen()
                }
            }
        }
    }
}

