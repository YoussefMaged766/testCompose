package com.example.testcompose.ui.ui.navigation

sealed class Screen( val route:String){
    object SplashScreen:Screen("splash_screen")
    object LoginScreen:Screen("login_screen")
    object SignUpScreen:Screen("sign_up_screen")


    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }

}
