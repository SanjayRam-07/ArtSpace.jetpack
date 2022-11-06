package com.example.artspace.ui.theme

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R
import com.example.artspace.ui.theme.ArtSpaceTheme

@Composable
fun ImageRes(currentVal:Int) {
    val color = if(isSystemInDarkTheme()) Color.White else Color.Black
    val img1= painterResource(id = R.drawable.img1)
    val img2= painterResource(id = R.drawable.img2)
    val img3= painterResource(id = R.drawable.img3)
    val img4= painterResource(id = R.drawable.img4)
    val img5= painterResource(id = R.drawable.img5)
    val not_found= painterResource(id = R.drawable.image_not_found)


    var currentImg=when(currentVal) {
        1->img1
        2->img2
        3->img3
        4->img4
        5->img5
        else->not_found
    }

    if (currentVal==0 || currentVal==6)
        Image(painter = currentImg,
            contentDescription = "CurrentImg",
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(color))
    else
        Image(painter = currentImg,
            contentDescription = "CurrentImg")

}