package com.choice.splash.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.choice.features.composable.yummyComposable
import com.choice.features.navigation.Destination
import com.choice.splash.ui.SplashUI

fun NavGraphBuilder.splashComposable(
    navController: NavHostController,
) {
    yummyComposable(
        destination = Destination.SplashScreen
    ) {
        SplashUI(navController)
    }
}