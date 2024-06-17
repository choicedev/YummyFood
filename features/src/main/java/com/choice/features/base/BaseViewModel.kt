package com.choice.features.base


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.choice.features.navigation.navigator.YuumyNavigator

abstract class BaseViewModel<STATE, EVENT>(
    initState: STATE,
    private val yuumyNavigator: YuumyNavigator
) : ViewModel() {

    var state by mutableStateOf(initState)

    val navigate = yuumyNavigator.navigationChannel

    fun navigateBack(
        route: String? = null,
        inclusive: Boolean = true
    ) {
        yuumyNavigator.tryNavigateBack(
            route,
            inclusive
        )
    }

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = true,
        isSingleTop: Boolean = false
    ) {
        yuumyNavigator.tryNavigateTo(
            route,
            popUpToRoute,
            inclusive,
            isSingleTop
        )
    }

    abstract fun onEvent(event: EVENT)

}