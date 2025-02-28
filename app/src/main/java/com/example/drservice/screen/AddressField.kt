package com.example.drservice.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreen(
//    modifier = Modifier.fillMaxSize()
){
    var address by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var landMark by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var pincode by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }



    Box (
        modifier = Modifier.padding(8.dp)
    ){
        Column () {

            CenterAlignedTopAppBar(
                title = { Text(
                    "ADDRESS",
                    fontWeight = FontWeight.Bold
                ) }
            )
            OutlinedTextField(
                label = { Text("Full Name") },
                value = name,
                onValueChange = {newname : String ->
                    name = newname },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                label = { Text("Address") },
                value = address,
                onValueChange = {new1 : String ->
                    address = new1 },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                label = { Text("LandMark") },
                value = landMark,
                onValueChange = {newlandmark : String ->
                    landMark = newlandmark },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                label = { Text("Mobile number") },
                value = number,
                onValueChange = {newnumber : String ->
                    number = newnumber },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Row {
                OutlinedTextField(
                    label = { Text("Pincode") },
                    value = pincode,
                    onValueChange = {newpincode : String ->
                        pincode = newpincode },
                    singleLine = true,
                    modifier = Modifier.requiredWidth(128.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    label = { Text("City") },
                    value = city,
                    onValueChange = {newcity : String ->
                        city = newcity },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                label = { Text("State") },
                value = state,
                onValueChange = {newstate : String ->
                    state = newstate },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

        }


    }

}

@Preview
@Composable
private fun Display(){
    AddressScreen()
}


