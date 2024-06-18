package com.choice.splash

import androidx.lifecycle.ViewModel
import com.choice.features.base.BaseViewModel
import com.choice.features.navigation.navigator.YummyNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    appNavigator: YummyNavigator
): BaseViewModel<Unit, Unit>(Unit, appNavigator) {
    override fun onEvent(event: Unit) {
    }
}