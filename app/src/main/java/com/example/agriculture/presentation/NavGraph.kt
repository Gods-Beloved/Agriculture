package com.example.agriculture.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController, startDestination = Screen.Login.route) {
        composable(
            route = Screen.Login.route
        ) {

            // ...
// Initialize Firebase Auth
            val auth: FirebaseAuth = Firebase.auth

            val currentUser = auth.currentUser

            if(currentUser != null){
                HomeScreen(navHostController)
            }else{
                MyApp(navHostController)
            }

        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUp(navHostController)
        }
        composable(
            route=Screen.HomeScreen.route
        ){
            HomeScreen(navController = navHostController)
        }

    }
}