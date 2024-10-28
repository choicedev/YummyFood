package com.choice.core.usecase

import com.choice.core.utils.IResult
import kotlinx.coroutines.flow.Flow

interface ResultUseCases<in I, out R : Any> {
    suspend operator fun invoke(input: I): Flow<IResult<R>>
}