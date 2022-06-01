package com.example.agriculture.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriculture.R
import com.example.agriculture.ui.theme.DeepGreen
import com.example.agriculture.ui.theme.boxBorderColor
import com.example.agriculture.ui.theme.dividerColor


@Composable
fun SignUpBackgroundImage(
    modifier: Modifier = Modifier,


    ) {
    Box {

        Surface(modifier = modifier.fillMaxSize(), elevation = 4.dp) {
            Image(
                painter = painterResource(id = R.drawable.signup_new),
                contentDescription = "agric_login", contentScale = ContentScale.FillBounds
            )
        }


    }


}

@Composable
fun SignUpDetails(navHostController: NavHostController) {
    Surface() {

        Column(Modifier.padding(16.dp)) {
            Text(
                "Sign Up", modifier = Modifier.padding(top = 21.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 36.sp
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp),


                ) {

                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }
                var full_name by remember { mutableStateOf("") }
                var isError by remember{mutableStateOf(false)}

                var showPassword by remember { mutableStateOf(false) }

                OutlinedTextField(
                    shape = RoundedCornerShape(4.dp),
                    value = full_name,
                    onValueChange = { full_name = it },
                    modifier = Modifier.fillMaxWidth(),

                    label = {

                        Text("Full Name")

                    },

                    )

                OutlinedTextField(
                    shape = RoundedCornerShape(4.dp),
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),

                    label = {

                        Text("Email")

                    }
                )


                OutlinedTextField(
                    value = password, onValueChange = { password = it }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
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

                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        disabledLeadingIconColor = DeepGreen
                    )


                )
                var _text by remember { mutableStateOf("")}
                OutlinedTextField(

                    value = confirmPassword, onValueChange = { confirmPassword = it }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    label = {
                        Text("Confirm Password")

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
                    onClick = {  SignUpCompose(
                        email = email,
                        password = confirmPassword,
                        navController = navHostController
                    )}



                    ,
                    Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(50.dp), shape = RoundedCornerShape(4.dp)


                ) {
                    _text = "Sign Up"
                    Text(
                        text=_text,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )

                }
                Row(
                    Modifier
                        .padding(top = 32.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Divider(
                        Modifier
                            .width(55.dp)
                            .align(Alignment.CenterVertically),
                        thickness = 1.dp,
                        color = dividerColor
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Or continue with", fontWeight = FontWeight(500), fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Divider(
                        Modifier
                            .width(55.dp)
                            .align(Alignment.CenterVertically),
                        thickness = 1.dp,
                        color = dividerColor
                    )

                }

                Row(
                    Modifier
                        .padding(top = 32.dp)
                        .align(Alignment.CenterHorizontally)
                ) {

                    Box() {
                        Surface(
                            border = BorderStroke(1.dp, color = boxBorderColor),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.size(55.dp)
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    painterResource(id = R.drawable.google),
                                    tint = Color.Unspecified,
                                    contentDescription = "google_icon",
                                    modifier = Modifier
                                        .align(alignment = Alignment.Center)
                                        .size(30.dp)
                                )
                            }

                        }

                    }

                    Spacer(Modifier.width(16.dp))

                    Box() {
                        Surface(
                            border = BorderStroke(1.dp, color = boxBorderColor),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.size(55.dp)
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    painterResource(id = R.drawable.facebook),
                                    tint = Color.Unspecified,
                                    contentDescription = "facebook_icon",
                                    modifier = Modifier
                                        .align(alignment = Alignment.Center)
                                        .size(30.dp)
                                )
                            }

                        }
                    }

                }


            }


        }


    }
}


@Composable
fun SignUp(navHostController: NavHostController) {



    Scaffold {
        Column {
            Row(
                modifier = Modifier.weight(1.3F)
            ) {
                SignUpBackgroundImage()
            }
            Row(modifier = Modifier.weight(6.0F)) {
                SignUpDetails(navHostController)
            }
        }
    }


}

