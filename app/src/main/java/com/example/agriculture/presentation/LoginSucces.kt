//
//package com.example.agriculture.presentation
//
//import android.util.Log
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.runtime.*
//import com.example.agriculture.util.AuthResultContract
//import com.example.agriculture.util.AuthViewModel
//import com.google.android.gms.common.api.ApiException
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun AuthScreen(authViewModel: AuthViewModel) {
//
//    val coroutineScope = rememberCoroutineScope()
//
//    var text by remember { mutableStateOf("")}
//
//    val user by remember (authViewModel){
//        authViewModel.user
//    }.collectAsState()
//
//    val signInRequestCode = 1
//
//    val authResultLauncher = rememberLauncherForActivityResult(contract = AuthResultContract()){
//        task ->
//        try {
//            val account = task?.getResult(ApiException::class.java)
//            if (account == null ){
//                Log.e("TAG", "AutheScreen: Error Ecountered", )
//                text = "google sign in failed"
//            }else{
//                coroutineScope.launch {
//                    account.let{
//                        authViewModel.signIn(email = it.email!!, displayName = it.displayName!!)
//                    }
//
//
//                }
//            }
//        }catch (e:ApiException){
//            Log.e("TAG", "AutheScreen: Error Ecountered", )
//            text = "Sign in failed"
//
//        }
//
//    }
//
//    GoogleSignInButtonUi(text = text,"Google Sign") {
//        authResultLauncher.launch(signInRequestCode)
//
//
//    }
//
//    user?.let{
//
//        HomeScreen(user = it)
//    }
//
//
//}