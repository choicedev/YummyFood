package com.choice.login.sign_in.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.choice.design.composable.PrimaryButton
import com.choice.design.composable.YummyOutlinedTextField
import com.choice.design.composable.YummyTextField
import com.choice.design.theme.YummyTheme
import com.choice.features.composable.YummyScaffold
import com.choice.login.LoginViewModel

@Composable
fun SignUp(navHostController: NavHostController) {

    val viewModel = hiltViewModel<LoginViewModel>()

    var text by remember {
        mutableStateOf("")
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
            ) { name, phone, email, password ->

            }

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = YummyTheme.spacing.extraLarge),
                text = "Sign Up",
                onClick = { }
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<LoginViewModel>()
    CenterAlignedTopAppBar(
        modifier = modifier
            .shadow(elevation = YummyTheme.spacing.extraExtraSmall),
        title = {
            Text(
                text = "Sign Up",
                color = YummyTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                viewModel.navigateBack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = YummyTheme.colors.onSurface
                )
            }
        }
    )
}


typealias onFormSubmit = (String, String, String, String) -> Unit

@Composable
fun FormRegister(
    modifier: Modifier = Modifier,
    onFormSubmit: onFormSubmit
) {

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Column(
        modifier = modifier
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = fullName,
            onValueChange = {
                fullName = it
            },
            placeholder = "Enter full name",
            title = "Full name"
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = phone,
            onValueChange = {
                phone = it
            },
            placeholder = "Enter your phone number",
            title = "Phone number"
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = "Enter email",
            title = "Email"
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = "Enter password",
            title = "Password"
        )

        onFormSubmit(
            fullName,
            phone,
            email,
            password
        )

    }
}


@Composable
fun TextField(
    value: String,
    title: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    YummyTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = YummyTheme.spacing.medium),
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        title = title,
        singleLine = true,
        keyboardActions = KeyboardActions{
            this.defaultKeyboardAction(ImeAction.Next)
        }
    )
}


