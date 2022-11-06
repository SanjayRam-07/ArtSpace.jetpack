package com.example.artspace

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerButtons
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.ui.theme.ImageRes
import com.example.artspace.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                val color=if(isSystemInDarkTheme()) Color.Black else Color.White
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color),
                    color = color
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var current by remember { mutableStateOf(1) }
    current=if (current<1) 0 else current
    current=if (current>5) 6 else current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageView(current)
        ArtDetails()
        Row(modifier = Modifier, horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { current -= 1 },
                colors = ButtonDefaults.buttonColors(Teal200)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { current += 1 },
                colors = ButtonDefaults.buttonColors(Teal200)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ImageView(current:Int,modifier: Modifier=Modifier) {

    Log.d(current.toString(),"curr")
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp)
        .border(
            width = 2.dp,
            color = Teal200,
            shape = RoundedCornerShape(10.dp)
        )
        .padding(all = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        ImageRes(currentVal = current)
    }
}

@Composable
fun ArtDetails() {
    Column(modifier = Modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Artwork Title")
        Text(text = "Artwork artist (year)")
    }
}

@Composable
fun RowScope.Buttons(text:String,w:Float,onValueChange:(Int) -> Unit) {
    Button(onClick = { onValueChange },
        modifier = Modifier.weight(w)) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}