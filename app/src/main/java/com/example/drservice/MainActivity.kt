package com.example.drservice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drservice.data.SecureStorage
import com.example.drservice.screen.HomeScreen
import com.example.drservice.screen.LoginPage
import com.example.drservice.screen.ProductList
import com.example.drservice.screen.signUp
import com.example.drservice.ui.theme.DRSERVICETheme
import com.example.drservice.viewmodel.AuthViewModel
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = AuthViewModel(applicationContext)
        // change to val
        var token = SecureStorage.getToken(applicationContext)
        setContent {
            val test_id = "xyz"
            val pass = "123"
            val testToken = "lkdsjfahsiuuifsdsibvjiaidb"
            // remove above 3 when deployed
            token = testToken
            // remove testToken too
            val navController = rememberNavController()
            intent?.let {
                if (it.action == Intent.ACTION_SEND && it.type == "text/plain") {
                    val sharedText = it.getStringExtra(Intent.EXTRA_TEXT)
                    if (sharedText != null) {
                        Log.i("My Tag","$sharedText I got it")
                        if(token == null) Toast.makeText(this, "login first", Toast.LENGTH_LONG).show()
                    }
                }
            }
         DRSERVICETheme {
             Surface( // This ensures background color adapts to theme
                 modifier = Modifier.fillMaxSize(),
                 color = MaterialTheme.colorScheme.background
             ) {
                 NavHost(navController = navController, startDestination = if (token!=null) HomeScreen else SignIn) {
                     composable<SignIn> {
                         LoginPage(navController, viewModel)
                     }
                     composable<SignUp> {
                         signUp()
                     }
                     composable<HomeScreen> {
                         HomeScreen(navController)
                     }
                 }
             }

         }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DRSERVICETheme {
        ProductList()
    }
}

@Serializable
object SignUp

@Serializable
object SignIn

@Serializable
object HomeScreen