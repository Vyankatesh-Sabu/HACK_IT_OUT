package com.example.drservice.screen

import android.content.ContentValues.TAG
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.drservice.R
import com.example.drservice.SignUp
import com.example.drservice.*
import com.example.drservice.viewmodel.AuthViewModel



@Composable
fun LoginPage(navController: NavController,viewModel: AuthViewModel){
    var email : String by rememberSaveable { mutableStateOf("") }
    var password : String by rememberSaveable { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()

    Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painterResource(R.drawable._957136_mobile_login), "login image")
            Text("Welcome", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Login to your Account")
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = email, onValueChange = { newemail ->
                email = newemail
            }, label = {
                Text("Email address")
            },
                )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField( value = password, onValueChange = {newpass->
                password = newpass
            }, label = {
                Text("Password")
            }, visualTransformation = PasswordVisualTransformation()
            ,

            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = {viewModel.login(email, password)}, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E3A8A)
            )) {
                Text("Login", color = Color.White)
            }
            Spacer(Modifier.height(16.dp))
           Row {
               Text("Forgot Password", modifier = Modifier.clickable {

               },)
               Spacer(modifier = Modifier.width(150.dp))
               Text("Sign Up", Modifier.clickable {
                    navController.navigate(SignUp)
               })
           }
            Spacer(Modifier.height(8.dp))
            Text("or sign in with")
            Spacer(Modifier.height(8.dp))
            Row {
                Icon(painter = painterResource(R.drawable.google_login), null)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(R.drawable.facebook_login), null)

            }
        }
    LaunchedEffect(authState) {
        authState?.let { result ->
            result.onSuccess { navController.navigate(HomeScreen) }
            result.onFailure { Log.d(TAG, "LoginPage: ${it.message}") }
        }
    }

}

