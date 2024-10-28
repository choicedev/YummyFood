package com.choice.login.domain.model

import com.choice.core.domain.model.Country
import com.choice.design.utils.PhoneNumberFormatter.Companion.getRawPhoneNumber

data class UserRegister(
    val fullName: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val country: Country = Country.BRAZIL
){

    val isValid = fullName.isNotEmpty() &&
            isValidPhoneNumber() &&
            password.isNotEmpty()

    private fun isValidPhoneNumber() = isValidFormatPhoneNumber()

    private fun isValidFormatPhoneNumber(): Boolean {
        val removeCountry = getRawPhoneNumber(phoneNumber, country, false)
        return when (country) {
            Country.BRAZIL -> removeCountry.length == country.limitNumber
            Country.USA -> removeCountry.length == country.limitNumber
            else -> false
        }
    }
}