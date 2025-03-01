package com.example.drservice.screen



import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.LottieConstants
import com.example.drservice.R
import com.example.drservice.SummaryScreen
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Loading(navController: NavController) {
//    LaunchedEffect(Unit) {
//        delay(10000) // Wait for 5 seconds
//        navController.navigate(SummaryScreen)
//    }

    val messages = listOf(
        "Processing input...",
        "Analyzing data...",
        "Generating response...",
        "Almost done..."
    )

    var currentMessageIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1500) // Change text every 1.5 seconds
            currentMessageIndex = (currentMessageIndex + 1) % messages.size
        }
    }

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.bouncing_circles))

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever, // Loop animation
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        AnimatedContent(
            targetState = messages[currentMessageIndex],
            transitionSpec = { fadeIn(animationSpec = tween(500)) with fadeOut(animationSpec = tween(500)) }
        ) { message ->
            Text(text = message, fontSize = 18.sp)
        }
    }
}

