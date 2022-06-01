package com.example.agriculture.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agriculture.ui.theme.DeepGreen
import com.example.agriculture.util.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsSection(
    navController: NavController,

) {








    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column {
            Text(
                "Log in", modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 36.sp
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
                    .verticalScroll(rememberScrollState()),


                ) {

                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var _text by remember { mutableStateOf("Sign In") }

                var showPassword by remember { mutableStateOf(false) }

                OutlinedTextField(
                    shape = RoundedCornerShape(4.dp),
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth().clickable {
                        _text = "Sign In"
                    },

                    label = {

                        Text("Email")

                    },
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                        }
                    }

                )
                OutlinedTextField(
                    value = password, onValueChange = { password = it }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp).clickable {
                            _text = "Sign In"
                        },
                    label = {
                        Text("Password")

                    },
                    trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        } else {
                            IconButton(onClick = { showPassword = true }) {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }

                    },

                    singleLine = true,
                    shape = RoundedCornerShape(4.dp),
                    leadingIcon = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                        }
                    },
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        disabledLeadingIconColor = DeepGreen
                    )


                )

                Button(
                    onClick = {
                        // ...
// Initialize Firebase Auth
                        val auth: FirebaseAuth = Firebase.auth

                        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                            if(it.isSuccessful){
                                navController.navigate(Screen.HomeScreen.route)

                            }else{
                                _text = "Sign in failure"

                            }
                        }

                    },
                    Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(50.dp), shape = RoundedCornerShape(4.dp)


                ) {
                    Text(
                        text=_text,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )

                }

                Text(
                    "Forgot Password?", fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.End),
                )

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
                    Row(
                        Modifier

                            .padding(bottom = 20.dp)

                    ) {
                        Text(
                            "Not having an account?",
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 16.sp,
                            fontSize = 14.sp
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.SignUp.route)
                            },
                            text="Sign up",
                            color = DeepGreen,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 16.sp,
                            fontSize = 14.sp
                        )
                    }

                }




            }


        }


    }

}


fun SignUpCompose(email:String,password:String,navController: NavController){
   val auth = Firebase.auth

   auth.createUserWithEmailAndPassword(email.trim(), password.trim())
       .addOnCompleteListener {
           if(it.isSuccessful){
               navController.navigate(Screen.Login.route)

           }else{
               Log.e("TAG", "SignUpCompose: Error Detected", )
           }

       }



}

