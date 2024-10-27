package com.choice.design.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.choice.core.di.model.Country
import com.choice.design.theme.YummyTheme
import com.choice.design.utils.PhoneNumberVisualTransformation

@Composable
fun YummyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    readOnly: Boolean = false,
//    textStyle: TextStyle = LocalTextStyle.current,
//    label: @Composable (() -> Unit)? = null,
    title: String? = null,
    placeholder: String? = null,
//    leadingIcon: @Composable (() -> Unit)? = null,
//    trailingIcon: @Composable (() -> Unit)? = null,
//    prefix: @Composable (() -> Unit)? = null,
//    suffix: @Composable (() -> Unit)? = null,
//    supportingText: @Composable (() -> Unit)? = null,
//    isError: Boolean = false,
//
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
//    keyboardActions: KeyboardActions = KeyboardActions.Default,
//    singleLine: Boolean = false,
//    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
//    minLines: Int = 1,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(tween(700))
            .padding(YummyTheme.spacing.extraExtraSmall)
    ) {
        title?.let {
            Text(
                modifier = Modifier.padding(
                    bottom = YummyTheme.spacing.small
                ),
                text = it,
                fontWeight = FontWeight.Bold,
                color = YummyTheme.colors.onSurface
            )
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .defaultMinSize(YummyTheme.spacing.ultraEpic + 50.dp)
                .border(BorderStroke(1.dp, YummyTheme.colors.outline), YummyTheme.shapes.medium)
                .padding(
                    horizontal = YummyTheme.spacing.mediumLarge,
                    vertical = YummyTheme.spacing.mediumSmall
                ),
            cursorBrush = SolidColor(YummyTheme.colors.primary),
            textStyle = YummyTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = YummyTheme.colors.onSurface
            ),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder ?: "",
                        color = Color.Gray,
                        style = YummyTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = YummyTheme.colors.onSurface
                        )
                    )
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun YummyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    title: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Column(
        modifier = Modifier
            .animateContentSize(tween(700))
            .padding(YummyTheme.spacing.extraExtraSmall)
    ) {
        title?.let {
            Text(
                modifier = Modifier.padding(
                    bottom = YummyTheme.spacing.small
                ),
                text = it,
                fontWeight = FontWeight.Bold,
                color = YummyTheme.colors.onSurface
            )
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.padding(
                vertical = 1.dp
            ),
            enabled = enabled,
            readOnly = readOnly,
            textStyle = YummyTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = YummyTheme.colors.onSurface
            ),
            label = label,
            placeholder = {
                placeholder?.let {
                    Text(
                        text = it,
                        color = YummyTheme.colors.outline,
                        style = YummyTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = YummyTheme.colors.onSurface
                        )
                    )
                }
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            shape = YummyTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = YummyTheme.colors.outline,
                unfocusedBorderColor = YummyTheme.colors.outline
            ),
        )
    }
}

@Composable
fun PhoneNumberFormatter(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String?,
    value: String,
    onValueChange: (String) -> Unit
) {
    var selectedCountry by remember { mutableStateOf(Country.BRAZIL) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {

        YummyTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            title = title,
            visualTransformation = PhoneNumberVisualTransformation(selectedCountry),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            prefix = {
                Row(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(YummyTheme.spacing.extraSmall))
                        .clickable { expanded = true },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,

                    ){
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 1.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(YummyTheme.spacing.large),
                                painter = painterResource(id = selectedCountry.flagResId),
                                contentDescription = null
                            )
                        }

                        DropdownMenu(
                            modifier = Modifier
                                .animateContentSize(animationSpec = tween(durationMillis = 1400))
                                .background(YummyTheme.colors.surface),
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            Country.entries.forEach { country ->
                                Row (
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .clip(shape = RoundedCornerShape(YummyTheme.spacing.mediumSmall))
                                        .padding(horizontal = YummyTheme.spacing.mediumSmall)
                                        .clickable {
                                            selectedCountry = country
                                            expanded = false
                                            onValueChange("")
                                        },
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Image(
                                        modifier = Modifier
                                            .size(YummyTheme.spacing.extraLarge),
                                        painter = painterResource(id = country.flagResId),
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(YummyTheme.spacing.mediumSmall))
                                    Text(
                                        text = country.ddd,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(YummyTheme.spacing.extraSmall))
                    Text(
                        text = selectedCountry.ddd,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(YummyTheme.spacing.extraSmall))
                }
            }
        )
    }
}
