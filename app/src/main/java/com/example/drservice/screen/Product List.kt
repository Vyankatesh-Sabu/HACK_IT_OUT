package com.example.drservice.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drservice.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductList(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text("Product", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 28.sp)
                    }
            },
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .drawBehind {
                    // Draw a line at the bottom of the Box
                    drawLine(
                        color = Color.Gray,
                        start = androidx.compose.ui.geometry.Offset(
                            0f,
                            size.height
                        ), // Bottom-left corner
                        end = androidx.compose.ui.geometry.Offset(
                            size.width,
                            size.height
                        ), // Bottom-right corner
                        strokeWidth = 8f // Thickness of the border
                    )
                }
            )
        },
        content = { innerPadding->
            Column(
                modifier = Modifier.padding(innerPadding)

            ) {
                LazyVerticalGrid (
                    columns = GridCells.Fixed(2),
                    content = {
                        items(100){ i->
                            Card(
                                shape = RoundedCornerShape(5.dp),
                                elevation = cardElevation(4.dp),
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Box(modifier = Modifier.padding(8.dp)) {
                                    Column {
                                        Row {
                                            Image(painter = painterResource(R.drawable.product_image), contentDescription = "Product Image", modifier = Modifier.size(64.dp))
                                            Column(
                                                modifier = Modifier.padding(8.dp)
                                            ) {
                                                Text("Product Name")
                                                Text("Product Price")
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                )

            }
        }
    )


}

@Preview
@Composable
private fun display(){
    ProductList()
}