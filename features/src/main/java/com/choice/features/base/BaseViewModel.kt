package com.choice.features.base


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.choice.features.navigation.Destination
import com.choice.features.navigation.navigator.YummyNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE, EVENT>(
    initState: STATE,
    private val yummyNavigator: YummyNavigator
) : ViewModel() {

    protected val _state = MutableStateFlow(initState)
    val state = _state.asStateFlow()

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