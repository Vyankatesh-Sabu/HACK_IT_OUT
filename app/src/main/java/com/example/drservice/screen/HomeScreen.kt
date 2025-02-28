package com.example.drservice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.drservice.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    var link : String by rememberSaveable{ mutableStateOf("") }
    Column  {
        CenterAlignedTopAppBar(
            title = { Text("Analyzer", fontSize = 28.sp, fontWeight = FontWeight.Bold) },

        )
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextField(value = link, onValueChange = {
                link = it
            },shape = RoundedCornerShape(16.dp),
                placeholder = { Text("Paste your Link here !") },
                modifier = Modifier.fillMaxWidth()
            )
            Row {
                Button(onClick = { /*TODO*/ },modifier = Modifier.padding(top = 20.dp)) {
                    Text("Analyze")
                }

                Button(onClick = { /*TODO*/ },modifier = Modifier.padding(top = 20.dp)) {
                    Text("Analyze")
                }
                Button(onClick = { /*TODO*/ },modifier = Modifier.padding(top = 20.dp)) {
                    Text("Analyze")
                }
            }
        }
    }

}