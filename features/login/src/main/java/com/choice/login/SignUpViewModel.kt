package com.choice.login

import androidx.lifecycle.viewModelScope
import com.choice.core.extend.result
import com.choice.features.base.BaseViewModel
import com.choice.features.navigation.navigator.YummyNavigator
import com.choice.login.domain.model.SignUpEvent
import com.choice.login.domain.model.SignUpState
import com.choice.login.domain.model.UserRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    yummyNavigator: YummyNavigator,
): BaseViewModel<SignUpState, SignUpEvent>(SignUpState(isLoading = false), yummyNavigator) {

    override fun onEvent(event: SignUpEvent) {
        viewModelScope.launch {
        }
    }

}