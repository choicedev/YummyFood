package com.choice.login.sign_up.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.choice.core.di.model.Country
import com.choice.design.composable.PhoneNumberFormatter
import com.choice.design.composable.PrimaryButton
import com.choice.design.composable.YummyTextField
import com.choice.design.theme.YummyTheme
import com.choice.features.composable.YummyScaffold
import com.choice.design.utils.PhoneNumberVisualTransformation
import com.choice.login.LoginViewModel
import com.choice.login.R

@Composable
fun SignUp(navHostController: NavHostController) {

    val viewModel = hiltViewModel<LoginViewModel>()
    val context = LocalContext.current

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
            ) { name, phone, password ->

            }

            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = YummyTheme.spacing.medium),
                text = context.getString(R.string.label_sign_up),
                onClick = { }
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        modifier = modifier
            .shadow(elevation = YummyTheme.spacing.extraExtraSmall),
        title = {
            Text(
                text = context.getString(R.string.label_sign_up_register),
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


typealias onFormSubmit = (String, String, String) -> Unit

@Composable
fun FormRegister(
    modifier: Modifier = Modifier,
    onFormSubmit: onFormSubmit
) {
    val context = LocalContext.current

    var fullName by remember {
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
            placeholder = context.getString(R.string.label_full_name_hint),
            title = context.getString(R.string.label_full_name)
        )

        PhoneNumberFormatter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = YummyTheme.spacing.medium),
            placeholder = context.getString(R.string.label_phone_number_hint),
            title = context.getString(R.string.label_phone_number),
            value = phone,
            onValueChange = {
                phone = it
            }
        )


        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = context.getString(R.string.label_password_hint),
            title = context.getString(R.string.label_password)
        )

        onFormSubmit(
            fullName,
            phone,
            password
        )

    }
}


@Composable
fun TextField(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    prefix: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
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
        prefix = prefix,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        isError = true,
        keyboardActions = KeyboardActions {
            this.defaultKeyboardAction(ImeAction.Next)
        }
    )
}

