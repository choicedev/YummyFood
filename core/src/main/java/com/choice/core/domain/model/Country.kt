package com.choice.core.domain.model

import com.choice.core.R

enum class Country(val flagResId: Int, val ddd: String, val limitNumber: Int) {
    BRAZIL(R.drawable.flag_brazil, "+55", 11),
    USA(R.drawable.flag_usa, "+1", 11)
}