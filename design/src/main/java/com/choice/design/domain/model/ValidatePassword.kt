package com.choice.design.domain.model

fun validatePassword(password: String): PasswordRequirements? {
    val hasUpperCase = password.any { it.isUpperCase() }
    val hasLowerCase = password.any { it.isLowerCase() }
    val hasDigit = password.any { it.isDigit() }
    val hasSpecialChar = password.any { !it.isLetterOrDigit() }

    val hasSequentialChars = (0 until password.length - 3).any { i ->
        password.substring(i, i + 4).all { it == password[i] } // 4 caracteres iguais
    }

    val commonPatterns = listOf("123456", "password", "qwerty", "abc", "letmein")
    val containsCommonPattern = commonPatterns.any { password.contains(it) }

    return when {
        password.isEmpty() -> null
        hasSequentialChars || containsCommonPattern -> PasswordRequirements.WEAK
        password.length > 16 && hasDigit -> PasswordRequirements.STRONG
        hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar -> PasswordRequirements.STRONG
        (hasUpperCase || hasLowerCase) && (hasDigit || hasSpecialChar) -> PasswordRequirements.MEDIUM
        else -> PasswordRequirements.WEAK
    }
}