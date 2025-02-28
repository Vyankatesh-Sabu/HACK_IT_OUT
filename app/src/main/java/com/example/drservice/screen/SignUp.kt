package com.example.drservice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drservice.R

@Preview
@Composable
fun signUp() {
    var email :String by rememberSaveable { mutableStateOf("") }
    var pass : String by rememberSaveable { mutableStateOf("") }
    var confirmPass :String by rememberSaveable  { mutableStateOf("") }
    var isError : Boolean by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painterResource(R.drawable.sign_up), "sign up image", modifier = Modifier.size(300.dp,300.dp))

        Text("Welcome", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Text("Login to your Account")

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(value = email, onValueChange = {newemail->
            email = newemail
        }, label = {
            Text("Email address")
        })

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(value = pass, onValueChange = {newpass->
            pass = newpass
        }, label = {
            Text("Password")
        }, visualTransformation = PasswordVisualTransformation(),
            supportingText = {
                if(isError) Text("Password Mismatch")
            })

        OutlinedTextField(value = confirmPass, onValueChange = {newConfirmPass->
            pass = newConfirmPass
        }, label = {
            Text("Confirm Password")
        }, visualTransformation = PasswordVisualTransformation(),
            supportingText = {
                if(isError) Text("Password Mismatch")
            })

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                if(confirmPass == pass) sendBack()//function
                else isError = true
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E3A8A)
            )
        ) {
            Text("Login")
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
}

fun sendBack(){}