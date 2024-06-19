package com.choice.design.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.choice.design.theme.YummyTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    backgroundColor: Color = YummyTheme.colors.primary,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable (() -> Unit)? = null,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = YummyTheme.colors.onPrimary
        ),
        elevation = elevation,
        border = border,
        contentPadding = PaddingValues(
            start = YummyTheme.spacing.large,
            top = YummyTheme.spacing.medium,
            bottom = YummyTheme.spacing.medium,
            end = YummyTheme.spacing.large
        ),
        interactionSource = interactionSource,
        onClick = onClick
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            if(icon != null){
                Box(
                    modifier = Modifier.padding(horizontal = YummyTheme.spacing.large)
                ){
                    icon()
                }
            }

            Text(
                text = text,
                style = YummyTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = YummyTheme.colors.surface
            )
        }
    }
}


@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(text = "Button", onClick = {})
}