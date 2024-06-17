package com.choice.features.navigation.navigator

import com.choice.features.navigation.NavigationIntent
import kotlinx.coroutines.channels.Channel

interface YuumyNavigator {

    val navigationChannel: Channel<NavigationIntent>

    suspend fun navigateBack(
        route: String? = null,
        inclusive: Boolean = true
    )

    fun tryNavigateBack(
        route: String? = null,
        inclusive: Boolean = true
    )

    suspend fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = true,
        isSingleTop: Boolean = true
    )

    fun tryNavigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = true,
        isSingleTop: Boolean = true,
    )

}