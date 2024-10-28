package com.choice.login.sign_up.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.choice.design.composable.PrimaryButton
import com.choice.design.theme.YummyTheme
import com.choice.features.composable.YummyScaffold
import com.choice.login.SignUpViewModel
import com.choice.login.R
import com.choice.login.design.composables.FormRegister
import com.choice.login.design.composables.SignUpTopBar
import com.choice.login.domain.model.UserRegister

@Composable
fun SignUp(navHostController: NavHostController) {

    val viewModel = hiltViewModel<SignUpViewModel>()
    val state = viewModel.state.collectAsState()


    val context = LocalContext.current

    var userRegister by remember {
        mutableStateOf(UserRegister())
    }

    YummyScaffold(
        navigation = viewModel.navigate,
        navController = navHostController,
        topBar = {
            SignUpTopBar()
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(YummyTheme.colors.surface)
                .padding(paddingValues)
                .padding(YummyTheme.spacing.medium)
                .padding(top = YummyTheme.spacing.mediumSmall),
        ) {

            FormRegister(
                modifier = Modifier.wrapContentSize()
            ) { name, phone, password, country ->
                userRegister = userRegister.copy(
                    fullName = name,
                    phoneNumber = phone,
                    password = password,
                    country = country
                )
            }

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = -YummyTheme.spacing.medium)
                    .padding(top = YummyTheme.spacing.medium),
                text = context.getString(R.string.label_sign_up),
                enabled = userRegister.isValid,
                onClick = {

                }
            )
        }
    }

}

