package com.example.agriculture.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agriculture.R

@Preview
@Composable
fun LoginBackgroundImage(
    modifier: Modifier = Modifier,

    ) {
    Box {

        Surface(modifier = Modifier.fillMaxSize(), elevation = 4.dp) {
            Image(
                painter = painterResource(id = R.drawable.agric_login),
                contentDescription = "agric_login", contentScale = ContentScale.FillBounds
            )
        }




        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    start =
                    16.dp, bottom = 85.dp
                )
        ) {
            Text(
                text = "Grow Your\nFarm With Us",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Text(
                text = "Starting from soil 0 to tree 1. nothing \nis too small to not grow.",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp),
                lineHeight = 15.sp
            )

        }
    }


}