package com.tech.techtest.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorMessage(displayText: String) {
    Text(text = displayText)
}