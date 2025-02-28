import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Preview()
@Composable
fun ChatScreen() {
    var messages by remember { mutableStateOf(listOf<Pair<String, Boolean>>()) }
    var inputText by remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .verticalScroll(scrollState)
        ) {
            messages.forEach { (message, isUser) ->
                ChatBubble(message, isUser)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(8.dp),
            )

            Button(onClick = {
                if (inputText.text.isNotBlank()) {
                    messages = messages + (inputText.text to true)
                    inputText = TextFieldValue("")

                    coroutineScope.launch {
                        messages = messages + ("Thinking..." to false)
                        // Simulating AI response
                        kotlinx.coroutines.delay(1000)
                        messages = messages.dropLast(1) + ("Hello!" to false)
                    }
                }
            }) {
                Text("Send")
            }
        }
    }
}

@Composable
fun ChatBubble(message: String, isUser: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(if (isUser) Color.Blue else Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp)
                .widthIn(max = 250.dp)
        ) {
            Text(text = message, color = Color.White, fontSize = 16.sp)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
