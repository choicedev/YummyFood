package com.choice.core.extend

import com.choice.core.utils.IResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <DTO> IResult<DTO>.result(
    success: ((DTO) -> Unit)? = null,
    failure: ((Throwable) -> Unit)? = null,
    error: ((Pair<String, String>) -> Unit)? = null,
    loading: ((String) -> Unit)? = null
){
    when(this){
        is IResult.OnSuccess -> success?.invoke(this.response)
        is IResult.OnFailed -> failure?.invoke(this.throwable)
        is IResult.OnError -> error?.invoke(this.error)
        is IResult.OnLoading -> loading?.invoke(this.message)
    }
}

suspend fun <DTO> Flow<IResult<DTO>>.result(
    success: ((DTO) -> Unit)? = null,
    failure: ((Throwable) -> Unit)? = null,
    error: ((Pair<String, String>) -> Unit)? = null,
    loading: ((String) -> Unit)? = null
) = this.collect { collect ->
        when(collect){
            is IResult.OnSuccess -> success?.invoke(collect.response)
            is IResult.OnFailed -> failure?.invoke(collect.throwable)
            is IResult.OnError -> error?.invoke(collect.error)
            is IResult.OnLoading -> loading?.invoke(collect.message)
        }
    }