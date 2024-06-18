package com.choice.features.base


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.choice.features.navigation.Destination
import com.choice.features.navigation.navigator.YummyNavigator

abstract class BaseViewModel<STATE, EVENT>(
    initState: STATE,
    private val yummyNavigator: YummyNavigator
) : ViewModel() {

    var state by mutableStateOf(initState)

    val navigate = yummyNavigator.navigationChannel

    fun navigateBack(
        route: String? = null,
        inclusive: Boolean = true
    ) {
        yummyNavigator.tryNavigateBack(
            route,
            inclusive
        )
    }

    fun navigateTo(
        route: Destination,
        popUpToRoute: Destination? = null,
        inclusive: Boolean = true,
        isSingleTop: Boolean = false
    ) {
        yummyNavigator.tryNavigateTo(
            route.fullRoute,
            popUpToRoute?.fullRoute,
            inclusive,
            isSingleTop
        )
    }

    abstract fun onEvent(event: EVENT)

}