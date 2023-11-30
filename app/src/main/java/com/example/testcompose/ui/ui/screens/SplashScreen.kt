package com.example.testcompose.ui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testcompose.R
import com.example.testcompose.ui.ui.navigation.Screen


@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavController) {
    Surface() {
        Image(
            painter = painterResource(id = R.drawable.splash_img),
            contentDescription = null,
            modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = modifier.fillMaxSize()) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1.5f)
            ) {
                Text(
                    text = "Aspen",
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp),
                    fontFamily = FontFamily(Font(R.font.hiatus)),
                    fontSize = 116.sp,
                    color = Color.White,
                    letterSpacing = 9.86.sp,
                    fontWeight = FontWeight(400)

                )
            }
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Column {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                                )
                            ) {
                                append("Plan your\n")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight(400),
                                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                                    fontSize = 47.sp
                                )
                            ) {
                                append("Luxurious\nVacation")
                            }

                        },
                        textAlign = TextAlign.Left,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 39.dp),
                        fontFamily = FontFamily(Font(R.font.hiatus)),
                        fontSize = 16.sp,
                        color = Color.White,
                        letterSpacing = 1.15.sp,
                        fontWeight = FontWeight(400)

                    )
                    Button(
                        onClick = { navController.navigate(Screen.SignUpScreen.route) },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.blue)
                        ),
                        shape = RoundedCornerShape(20),
                    ) {
                        Text(
                            text = "Explore",
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
                }

            }


        }

    }

}