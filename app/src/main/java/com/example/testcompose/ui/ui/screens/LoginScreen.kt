package com.example.testcompose.ui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testcompose.R
import com.example.testcompose.ui.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.img_signup),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Enter to your personal profile.com and follow.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                color = Color.Black,
            )

            var txtPhone by rememberSaveable { mutableStateOf("") }
            var isErrorPhone by rememberSaveable { mutableStateOf(false) }
            val keyboardController = LocalSoftwareKeyboardController.current

            fun validatePhone(txtPhone: String) {
                isErrorPhone = txtPhone.length < 3 || txtPhone.isEmpty()
            }
            TextField(
                value = txtPhone,
                onValueChange = {
                    txtPhone = it
                    validatePhone(txtPhone)
                },
                label = { Text(text = "Phone") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .semantics {
                        if (isErrorPhone) error("Phone is required")
                    },
                placeholder = { Text(text = "Enter your Phone") },
                leadingIcon = { Icon(Icons.Filled.Call, contentDescription = null) },
                supportingText = { Text(text = "*required") },
                isError = isErrorPhone,
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = colorResource(id = R.color.blue),
                    focusedLeadingIconColor = colorResource(id = R.color.blue),
                    focusedLabelColor = colorResource(id = R.color.blue),
                )
            )


            var txtPassword by rememberSaveable { mutableStateOf("") }
            var isErrorPassword by rememberSaveable { mutableStateOf(false) }
            var passwordHidden by rememberSaveable { mutableStateOf(true) }

            fun validatePassword(txtPassword: String) {
                isErrorPassword = txtPassword.length < 6 || txtPassword.isEmpty()
            }
            TextField(
                value = txtPassword,
                onValueChange = {
                    txtPassword = it
                    validatePassword(txtPassword)
                },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .semantics {
                        if (isErrorPassword) error("Password is required")
                    },
                placeholder = { Text(text = "Enter your password") },
                supportingText = { Text(text = "*required") },
                isError = isErrorPassword,
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val iconVisibility =
                            if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(imageVector = iconVisibility, contentDescription = description)
                    }
                },
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = colorResource(id = R.color.blue),
                    focusedLeadingIconColor = colorResource(id = R.color.blue),
                    focusedLabelColor = colorResource(id = R.color.blue),
                )
            )
            Button(
                onClick = { null },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue)
                ),
                shape = RoundedCornerShape(20),
            ) {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight(400)
                )
            }

            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                Text(
                    text = "Don't have an account? ",
                    modifier = modifier.padding(start = 16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    )
                )
                ClickableText(
                    onClick = { navController.navigate(Screen.SignUpScreen.route) },
                    modifier = modifier.padding(0.dp),
                    text = AnnotatedString("Sign Up"),
                    style = TextStyle(
                        color = colorResource(id = R.color.blue),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_medium),
                        ),
                        textDecoration = TextDecoration.Underline
                    ),
                )
            }
        }
    }
}