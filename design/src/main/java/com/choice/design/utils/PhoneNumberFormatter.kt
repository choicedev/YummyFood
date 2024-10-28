package com.choice.design.utils

import com.choice.core.domain.model.Country

class PhoneNumberFormatter {

    fun formatBrazilianPhoneNumber(number: String): String {
        val length = number.length
        return when {
            length == 2 -> "(${number.substring(0, 2)}) "
            length in 3..6 -> "(${number.substring(0, 2)}) ${number.substring(2)}"
            length >= 7 -> "(${number.substring(0, 2)}) ${number.substring(2, 7)}-${number.substring(7)}"
            else -> number
        }
    }

    fun formatUSPhoneNumber(number: String): String {
        val length = number.length
        return when {
            length == 3 -> "${number.substring(0, 3)}-"
            length in 4..6 -> "${number.substring(0, 3)}-${number.substring(3)}"
            length >= 7 -> "${number.substring(0, 3)}-${number.substring(3, 6)}-${number.substring(6)}"
            else -> number
        }
    }

    companion object {
        fun getRawPhoneNumber(phoneNumber: String, country: Country, withDDD: Boolean = true): String {
            val ddd = country.ddd
            val rawNumber = phoneNumber.replace("[^0-9]".toRegex(), "")
            return if(withDDD) "$ddd$rawNumber" else rawNumber
        }
    }
}