package com.example.drservice.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(text: String) {
    var displayedText by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(text) {
        displayedText = ""
        text.forEachIndexed { index, _ ->
            delay(50) // Adjust speed
            displayedText = text.substring(0, index + 1)
        }
    }

    Text(text = displayedText, fontSize = 18.sp)
}

@Composable
fun SummaryScreen() {
    val summary = "This is a dynamically typed summary appearing like ChatGPT."
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TypewriterText(text = summary)
    }
}


@Preview
@Composable
fun SummaryScreenPreview() {
    SummaryScreen()
}