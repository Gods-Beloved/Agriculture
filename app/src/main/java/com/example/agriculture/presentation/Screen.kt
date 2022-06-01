package com.example.agriculture.presentation

sealed class Screen(val route:String) {
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object HomeScreen : Screen(route = "home_screen")
}
