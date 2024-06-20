package com.choice.features.composable

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.choice.features.navigation.Destination

@Composable
fun YummyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Destination = Destination.SplashScreen,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.fullRoute,
        route = route,
        builder = builder
    )

}

fun NavGraphBuilder.yummyComposable(
    destination: Destination,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideInHorizontally(
            animationSpec = tween(800),
            initialOffsetX = { fullWidth -> fullWidth }
        ) + fadeIn(tween(1000))
    },
    exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutHorizontally(
            animationSpec = tween(800),
            targetOffsetX = { fullWidth -> -fullWidth }
        ) + fadeOut(tween(1000))
    },
    popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?
    )? = {
        slideInHorizontally(
            animationSpec = tween(800),
            initialOffsetX = { fullWidth -> -fullWidth }
        ) + fadeIn(tween(1000))
    },
    popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?
    )? = {
        slideOutHorizontally(
            animationSpec = tween(800),
            targetOffsetX = { fullWidth -> fullWidth }
        ) + fadeOut(tween(1000))
    },
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    composable(
        route = destination.fullRoute,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
        content = content
    )

}