package com.choice.login.design.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.choice.core.domain.model.Country
import com.choice.design.composable.PhoneNumberFormatter
import com.choice.design.theme.YummyTheme
import com.choice.login.R
import com.choice.login.SignUpViewModel
import com.choice.login.design.components.TextField
import com.choice.login.design.components.TextFieldPassword

typealias onFormSubmit = (String, String, String, Country) -> Unit

@Composable
fun FormRegister(
    modifier: Modifier = Modifier,
    onFormSubmit: onFormSubmit
) {

    val viewModel = hiltViewModel<SignUpViewModel>()
    val state by viewModel.state.collectAsState()

    var fullName by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var countrySelected by remember {
        mutableStateOf(Country.BRAZIL)
    }

    Column(
        modifier = modifier
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = fullName,
            onValueChange = {
                if(it.all { char -> char.isLetter() || char.isWhitespace() }) fullName = it
            },
            placeholder = stringResource(R.string.label_full_name_hint),
            title = stringResource(R.string.label_full_name),
        )

        PhoneNumberFormatter(
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(R.string.label_phone_number_hint),
            title = stringResource(R.string.label_phone_number),
            value = phoneNumber,
            onCountryValue = {
                countrySelected = it
            },
            onValueChange = {
                if(it.isDigitsOnly()) phoneNumber = it.take(countrySelected.limitNumber)

            }
        )

        TextFieldPassword(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = stringResource(R.string.label_password_hint),
            title = stringResource(R.string.label_password),
        )

        onFormSubmit(
            fullName,
            phoneNumber,
            password,
            countrySelected
        )

    }
}
