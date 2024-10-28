package com.choice.login.design.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.choice.design.theme.YummyTheme
import com.choice.login.SignUpViewModel
import com.choice.login.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<SignUpViewModel>()
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
