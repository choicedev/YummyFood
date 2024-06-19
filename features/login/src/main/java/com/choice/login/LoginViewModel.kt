package com.choice.login

import com.choice.features.base.BaseViewModel
import com.choice.features.navigation.navigator.YummyNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    yummyNavigator: YummyNavigator
): BaseViewModel<Unit, Unit>(Unit, yummyNavigator) {
    override fun onEvent(event: Unit) {
    }

}