package com.example.agriculture.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agriculture.ui.theme.AgricultureTheme


@Composable
fun MyApp(navController: NavController) {


    Column(modifier = Modifier
        .background(color = Color.White)) {
        Row(
            modifier = Modifier
                .weight(1.1f)
                .fillMaxWidth()


            ) {
            LoginBackgroundImage()

        }
        Row(
            modifier = Modifier
                .weight(1.6f)
                .fillMaxWidth()
        ) {


            DetailsSection(navController)
        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AgricultureTheme {


        MyApp(rememberNavController())


    }
}