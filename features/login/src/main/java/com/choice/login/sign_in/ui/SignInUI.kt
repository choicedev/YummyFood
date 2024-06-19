package com.choice.login.sign_in.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.choice.design.composable.YummyTextField
import com.choice.design.composable.YummyTextFieldBaisc
import com.choice.features.composable.YummyScaffold
import com.choice.login.LoginViewModel

@Composable
fun SignIn(navHostController: NavHostController) {

    val viewModel = hiltViewModel<LoginViewModel>()

    var text by remember {
        mutableStateOf("")
    }

    YummyScaffold(
        navigation = viewModel.navigate,
        navController = navHostController
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            YummyTextFieldBaisc(
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = "Nome",
                title = "Your Name"
            )
        }
    }

}


