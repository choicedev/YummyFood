package com.choice.login.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.choice.features.composable.YummyScaffold

@Composable
fun LoginUI(navController: NavController){

    YummyScaffold {
        Text(modifier = Modifier.padding(it), text = "aAA")
    }
}