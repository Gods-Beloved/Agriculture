package com.example.agriculture.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController, startDestination = Screen.Login.route) {
        composable(
            route = Screen.Login.route
        ) {
            MyApp(navHostController)
        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUp(navHostController)
        }
        composable(
            route=Screen.HomeScreen.route
        ){
            HomeScreen()
        }

    }
}