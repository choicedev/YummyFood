package com.choice.yummyfood.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.choice.features.composable.YummyNavHost
import com.choice.login.login.navigation.loginComposable
import com.choice.login.sign_in.navigation.signUpComposable
import com.choice.splash.navigation.splashComposable

@Composable
fun YummyUI() {

    val navController = rememberNavController()

    YummyNavHost(navController = navController) {
        splashComposable(navController)
        loginComposable(navController)
        signUpComposable(navController)
    }
}