package com.choice.features.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.choice.design.theme.YummyTheme
import com.choice.features.navigation.NavigationEffects
import com.choice.features.navigation.NavigationIntent
import kotlinx.coroutines.channels.Channel
import java.io.IOException


@Composable
fun YummyScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    navigation: Channel<NavigationIntent>? = null,
    navController: NavHostController? = null,
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = YummyTheme.colors.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    content: @Composable (PaddingValues) -> Unit
) {

    navigation?.let {
        navController?.let { nav ->
            NavigationEffects(
                navigationChannel = it,
                navHostController = nav
            )
        } ?: throw IOException("navigation without navController")
    }


    Scaffold(
        modifier,
        topBar,
        bottomBar,
        snackbarHost = {},
        floatingActionButton,
        floatingActionButtonPosition,
        containerColor,
        contentColor,
        contentWindowInsets,
        content
    )
}