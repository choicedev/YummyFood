package com.choice.features.navigation

sealed class Destination(
    protected val route: String,
    vararg params: String
) {

    data object SplashScreen : NoArgumentsDestination("splash")
    data object LoginScreen : NoArgumentsDestination("login")

    val fullRoute: String = if (params.isEmpty()) route
    else StringBuilder(route).let { builder ->
        params.forEach { p -> builder.append("/{${p}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke() = route
    }

    internal fun String.appendParams(vararg params: Pair<String, Any?>): String =
        StringBuilder(this).let { builder ->
            params.forEach { p ->
                p.second?.toString()?.let { args ->
                    builder.append("/$args")
                }
            }
            builder.toString()
        }
}