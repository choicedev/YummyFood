package com.choice.design.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

object YummyTheme {

    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes


    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current
}

