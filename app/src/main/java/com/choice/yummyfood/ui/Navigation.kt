package com.choice.yummyfood.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.choice.features.composable.YummyNavHost
import com.choice.login.navigation.loginComposable
import com.choice.splash.navigation.splashComposable

@Composable
fun YummyNavController() {

    val navController = rememberNavController()

    YummyNavHost(navController = navController) {
        splashComposable(navController)
        loginComposable(navController)
    }
}