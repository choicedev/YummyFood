package com.choice.design.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.choice.design.R
import com.choice.design.theme.YummyTheme

@Composable
fun YummyLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier){
        Text(
            text = "YUMMY",
            color = YummyTheme.colors.primary,
            style = YummyTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "F",
            color = YummyTheme.colors.onSecondaryContainer,
            style = YummyTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Icon(
            modifier = Modifier
                .size(YummyTheme.spacing.massive)
                .offset(y = -YummyTheme.spacing.medium),
            painter = painterResource(id = R.drawable.logo_icon),
            tint = YummyTheme.colors.primary,
            contentDescription = null
        )
        Text(
            text = "D",
            color = YummyTheme.colors.onSecondaryContainer,
            style = YummyTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }
}