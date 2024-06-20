package com.choice.login.login.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.choice.features.composable.yummyComposable
import com.choice.features.navigation.Destination
import com.choice.login.login.ui.LoginUI

fun NavGraphBuilder.loginComposable(
    navController: NavHostController,
) {
    yummyComposable(
        destination = Destination.LoginScreen
    ) {
        LoginUI(navController)
    }
}