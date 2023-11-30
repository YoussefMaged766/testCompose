package com.example.testcompose.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testcompose.R
import com.example.testcompose.ui.ui.navigation.Navigation


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          Navigation()
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
//@Composable
//fun SignUpScreen(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.surface
//    ) {
//        Column {
//            Image(
//                painter = painterResource(id = R.drawable.img_signup),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(100.dp)
//                    .padding(16.dp)
//                    .align(Alignment.CenterHorizontally)
//
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Sign Up",
//                style = MaterialTheme.typography.headlineLarge,
//                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                color = Color.Black,
//                fontWeight = FontWeight.Bold
//            )
//            Text(
//                text = "Create your personal profile.com and follow",
//                style = MaterialTheme.typography.bodyLarge,
//                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 16.dp),
//                color = Color.Black,
//            )
//            var txtName by rememberSaveable { mutableStateOf("") }
//            var isError by rememberSaveable { mutableStateOf(false) }
//            val keyboardController = LocalSoftwareKeyboardController.current
//            fun validateName(txtName: String) {
//                isError = txtName.length < 3 || txtName.isEmpty()
//            }
//            TextField(
//                value = txtName,
//                onValueChange = {
//                    txtName = it
//                    validateName(txtName)
//                },
//                label = { Text(text = "Name") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .semantics {
//                        if (isError)
//                            error("Name is required")
//                    },
//                placeholder = { Text(text = "Enter your name") },
//                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
//                supportingText = { Text(text = "*required") },
//                isError = isError,
//                singleLine = true,
//                keyboardActions = KeyboardActions(
//                    onDone = {
//                        keyboardController?.hide()
//                    }
//                ),
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//            )
//            var txtPassword by rememberSaveable { mutableStateOf("") }
//            var isErrorPassword by rememberSaveable { mutableStateOf(false) }
//            var passwordHidden by rememberSaveable { mutableStateOf(true) }
//            fun validatePassword(txtPassword: String) {
//                isErrorPassword = txtPassword.length < 6 || txtPassword.isEmpty()
//            }
//            TextField(
//                value = txtPassword,
//                onValueChange = {
//                    txtPassword = it
//                    validatePassword(txtPassword)
//                },
//                label = { Text(text = "Password") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .semantics {
//                        if (isErrorPassword)
//                            error("Password is required")
//                    },
//                placeholder = { Text(text = "Enter your password") },
//                supportingText = { Text(text = "*required") },
//                isError = isErrorPassword,
//                singleLine = true,
//                keyboardActions = KeyboardActions(
//                    onDone = {
//                        keyboardController?.hide()
//                    }
//                ),
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                trailingIcon = {
//                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
//                        val iconVisibility = if (passwordHidden)
//                            Icons.Filled.Visibility else Icons.Filled.VisibilityOff
//
//                        val description = if (passwordHidden) "Show password" else "Hide password"
//                        Icon(imageVector = iconVisibility, contentDescription = description)
//                    }
//                },
//                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
//                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) }
//            )
//
//            var txtCity by rememberSaveable { mutableStateOf("") }
//            var isErrorCity by rememberSaveable { mutableStateOf(false) }
//
//            fun validateCity(txtName: String) {
//                isErrorCity = txtName.length < 3 || txtName.isEmpty()
//            }
//            TextField(
//                value = txtCity,
//                onValueChange = {
//                    txtCity = it
//                    validateCity(txtCity)
//                },
//                label = { Text(text = "City") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .semantics {
//                        if (isErrorCity)
//                            error("City is required")
//                    },
//                placeholder = { Text(text = "Enter your City") },
//                leadingIcon = { Icon(Icons.Filled.LocationCity, contentDescription = null) },
//                supportingText = { Text(text = "*required") },
//                isError = isErrorCity,
//                singleLine = true,
//                keyboardActions = KeyboardActions(
//                    onDone = {
//                        keyboardController?.hide()
//                    }
//                ),
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//            )
//
//
//        }
//    }
//}

