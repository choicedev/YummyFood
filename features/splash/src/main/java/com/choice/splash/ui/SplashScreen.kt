package com.choice.splash.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.choice.design.theme.YummyTheme
import com.choice.design.theme.component.YummyLogo
import com.choice.features.composable.YummyScaffold
import com.choice.features.navigation.Destination
import com.choice.splash.R
import com.choice.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashUI(navHostController: NavHostController) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.yummy_logo_animate)
    )
    val viewModel = hiltViewModel<SplashViewModel>()
    var navigate = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        delay(4000)
        viewModel.navigateTo(
            route = Destination.LoginScreen
        )
    }

    YummyScaffold(
        navController = navHostController,
        navigation = viewModel.navigate
    ) {
        Column(
            modifier = Modifier
                .animateContentSize()
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LottieAnimation(
                modifier = Modifier.fillMaxWidth(),
                composition = composition,
                iterations = 1,
                restartOnPlay = false,
            )
        }
    }
}