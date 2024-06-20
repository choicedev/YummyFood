package com.choice.login.sign_in.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.choice.features.composable.yummyComposable
import com.choice.features.navigation.Destination
import com.choice.login.sign_in.ui.SignUp

fun NavGraphBuilder.signInComposable(
    navController: NavHostController,
) {
    yummyComposable(
        destination = Destination.SigninScreen) {
        SignUp(navController)
    }
}