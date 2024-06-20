package com.choice.yummyfood

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.choice.design.theme.YummyTheme
import com.choice.yummyfood.ui.YummyUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        systemSettings()
        applicationUI()

    }

    private fun applicationUI() {
        setContent {
            YummyTheme {
                YummyUI()
            }
        }
    }

    private fun systemSettings() {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
        )
    }
}
