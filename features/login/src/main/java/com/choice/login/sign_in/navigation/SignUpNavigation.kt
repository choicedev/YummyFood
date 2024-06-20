package com.choice.login.sign_in.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.choice.features.composable.yummyComposable
import com.choice.features.navigation.Destination
import com.choice.login.sign_in.ui.SignUp

fun NavGraphBuilder.signUpComposable(
    navController: NavHostController,
) {
    yummyComposable(
        destination = Destination.SignUpScreen) {
        SignUp(navController)
    }
}