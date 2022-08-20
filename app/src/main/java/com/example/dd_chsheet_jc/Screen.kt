package com.example.dd_chsheet_jc

//only allows inside classed in here to inherit from this class, locked from outside
sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object RegisterScreen : Screen("register_screen")
    object ResetPasswordScreen : Screen("reset_password_screen")



    //if want to send arguments -> change route with withArgs and pass data
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }

}
