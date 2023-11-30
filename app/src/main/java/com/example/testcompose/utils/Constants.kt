package com.example.testcompose.utils

import androidx.compose.ui.graphics.Color


object Constants {
    fun String.toColor(hexColor:String) = Color(android.graphics.Color.parseColor(hexColor))
}