package com.choice.design.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import com.choice.core.domain.model.Country

class PhoneNumberVisualTransformation(private val country: Country) : VisualTransformation {

    private val formatter = PhoneNumberFormatter()

    override fun filter(text: AnnotatedString): TransformedText {
        val formatted = when (country) {
            Country.BRAZIL -> formatter.formatBrazilianPhoneNumber(if (text.text.length >= 11) text.text.substring(0..10) else text.text)
            Country.USA -> formatter.formatUSPhoneNumber(if (text.text.length >= 10) text.text.substring(0..9) else text.text)
        }

        return TransformedText(
            AnnotatedString(formatted),
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    return formatted.length
                }

                override fun transformedToOriginal(offset: Int): Int {
                    return text.length
                }
            }
        )
    }
}