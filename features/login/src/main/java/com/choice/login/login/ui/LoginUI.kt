package com.choice.login.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.choice.design.theme.YummyTheme
import com.choice.design.component.YummyLogo
import com.choice.design.composable.PrimaryButton
import com.choice.features.composable.YummyScaffold
import com.choice.features.navigation.Destination
import com.choice.login.LoginViewModel
import com.choice.login.R

@Composable
fun LoginUI(navController: NavHostController) {

    val viewModel = hiltViewModel<LoginViewModel>()

    YummyScaffold(
        navController = navController,
        navigation = viewModel.navigate
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .wrapContentSize()
        ) {
            FoodBackground()

            YummyLogo(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = YummyTheme.spacing.extraColossal + 60.dp)
            )

            ButtonsLogin(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize()
                    .padding(horizontal = YummyTheme.spacing.large),
                onSignUpClick = {
                    viewModel.navigateTo(
                        route = Destination.SigninScreen
                    )
                }
            )
        }
    }
}

@Composable
fun ButtonsLogin(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.padding(vertical = YummyTheme.spacing.extraHuge)
        )

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = YummyTheme.spacing.colossal),
            text = "Sign in",
            onClick = { }
        )

        OrDivider()

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Continue with Google",
            backgroundColor = Color(red = 83, green = 132, blue = 238),
            onClick = { }
        ) {
            Image(painter = painterResource(id = R.drawable.icon_google), contentDescription = null)
        }

        RegisterUserText(
            modifier = Modifier
                .fillMaxWidth(),
            onSignUpClick = onSignUpClick
        )

    }
}

@Composable
fun RegisterUserText(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = YummyTheme.spacing.medium),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Do not have an account?",
            color = YummyTheme.colors.scrim,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.width(YummyTheme.spacing.extraExtraSmall))

        TextButton(onClick = {
            onSignUpClick()
        }) {
            Text(
                text = "Sign up",
                color = YummyTheme.colors.primary,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }
}

@Composable
fun OrDivider(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(YummyTheme.spacing.medium))

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = YummyTheme.spacing.huge),
            color = YummyTheme.colors.outlineVariant
        )

        Text(
            text = "or",
            color = YummyTheme.colors.outline,
            modifier = Modifier
                .background(
                    color = YummyTheme.colors.background,
                    shape = CircleShape
                )
                .padding(YummyTheme.spacing.mediumSmall)
        )
    }
}

@Composable
fun BoxScope.FoodBackground(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .align(Alignment.TopCenter)
            .scale(2.2f)
            .offset(y = 30.dp, x = -(10).dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.White),
                    startY = 100f,
                    endY = Float.POSITIVE_INFINITY
                )
            ),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.food_background),
        contentDescription = null
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 200.dp)
            .offset(y = 200.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, YummyTheme.colors.background),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
    )
}