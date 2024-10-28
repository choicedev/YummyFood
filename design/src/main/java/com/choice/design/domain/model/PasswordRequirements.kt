package com.choice.design.domain.model

import androidx.annotation.StringRes
import com.choice.design.R

enum class PasswordRequirements(@StringRes val label: Int) {
    WEAK(R.string.password_requirement_weak),
    MEDIUM(R.string.password_requirement_medium),
    STRONG(R.string.password_requirement_strong)
}