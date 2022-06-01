package com.example.agriculture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriculture.ui.theme.AgricultureTheme


class MainActivity : ComponentActivity() {


lateinit var navControl:NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgricultureTheme {
                
                navControl = rememberNavController()
                
                SetUpNavGraph(navHostController = navControl)



                // A surface container using the 'background' color from the theme

            }
        }
    }
}






