package com.example.drservice.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.drservice.viewmodel.LinkViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: LinkViewModel, navController: NavController, sharedText: String?) {
    var linkText by remember { mutableStateOf(TextFieldValue("")) }
    val output by viewModel.output.collectAsState()
    val options = listOf("Sentiment","Emotion","Summary")
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var link by rememberSaveable { mutableStateOf("") }

    linkText = sharedText?.let { TextFieldValue(it) } ?: linkText

    Column {
        CenterAlignedTopAppBar(
            title = { Text("Analyzer", fontSize = 28.sp, fontWeight = FontWeight.Bold) }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Text Field for Input
            TextField(
                value = linkText,
                onValueChange = {
                    linkText = it
                                },
                shape = RoundedCornerShape(16.dp),
                placeholder = { Text("Paste your Link here !") },
                modifier = Modifier.fillMaxWidth()
            )

            // Analyze Buttons (Placeholder)
            Spacer(modifier = Modifier.height(16.dp))

            // ChatGPT-style selectable options
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                options.forEach { option ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (selectedOption == option) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { selectedOption = option }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = option,
                            color = if (selectedOption == option) Color.White else Color.Black,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }


            // Send Link Button
            Button(onClick = {
                viewModel.updateLink(linkText.text)
                viewModel.sendLink()
            },
                enabled = linkText.text.isNotBlank()) {
                Text("Send Link")
            }

            output?.let {
                Text(text = it, style = MaterialTheme.typography.bodyLarge)
            }


            // Loading Indicator

        }
    }
}
