package com.choice.core.utils

import androidx.annotation.Keep

@Keep
sealed class IResult<out DTO> {
    data class OnSuccess<out DTO>(val response: DTO) : IResult<DTO>()
    data class OnFailed(val throwable: Throwable) : IResult<Nothing>()
    data class OnError(val error: Pair<String, String>) : IResult<Nothing>()
    data class OnLoading(val message: String) : IResult<Nothing>()


    companion object {

        fun <OUT> success(data: OUT) = OnSuccess(data)

        fun failed(exceptionError: Throwable) = OnFailed(exceptionError)

        fun loading(message: String = "Waiting..") = OnLoading(message)

        suspend fun <DTO> IResult<DTO>.onSuccess(block: suspend (DTO) -> Unit) = apply {
            if(this is OnSuccess){
                block(this.response)
            }
        }

        suspend fun <DTO> IResult<DTO>.onFailed(block: suspend (exception: Throwable) -> Unit) = apply {
            if(this is OnFailed){
                block(this.throwable)
            }
        }

        suspend fun <DTO> IResult<DTO>.onLoading(block: suspend (message: String) -> Unit) = apply {
            if(this is OnLoading){
                block(this.message)
            }
        }

    }

}