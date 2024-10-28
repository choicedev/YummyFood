package com.choice.login.design.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.choice.design.composable.PasswordStrengthIndicator
import com.choice.design.composable.YummyTextField
import com.choice.design.theme.YummyTheme

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    placeholder: String,
    isError: Boolean = false,
    textError: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    prefix: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    YummyTextField(
        modifier = modifier.padding(bottom = YummyTheme.spacing.medium),
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        title = title,
        singleLine = true,
        prefix = prefix,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        isError = isError,
        supportingText = textError,
        supportingTextColor = YummyTheme.colors.error,
        keyboardActions = KeyboardActions {
            this.defaultKeyboardAction(ImeAction.Next)
        }
    )
}


@Composable
fun TextFieldPassword(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    placeholder: String,
    isError: Boolean = false,
    textError: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    prefix: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .animateContentSize()
            .padding(bottom = YummyTheme.spacing.medium),
        horizontalAlignment = Alignment.Start
    ) {

        YummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            title = title,
            singleLine = true,
            prefix = prefix,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = keyboardOptions,
            isError = isError,
            supportingText = if (isError) textError else "",
            supportingTextColor = YummyTheme.colors.error,
            keyboardActions = KeyboardActions(
                onDone = { this.defaultKeyboardAction(ImeAction.Done) }
            ),
            trailingIcon = {
                val icon = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (isPasswordVisible) "Hide password" else "Show password"
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            }
        )
         PasswordStrengthIndicator(
             modifier = Modifier
                 .padding(horizontal = YummyTheme.spacing.mediumSmall)
                 .offset(y = -YummyTheme.spacing.mediumSmall),
             password = value
         )
    }
}

