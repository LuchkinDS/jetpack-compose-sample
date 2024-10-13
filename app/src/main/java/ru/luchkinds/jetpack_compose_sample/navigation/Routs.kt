package ru.luchkinds.jetpack_compose_sample.navigation

import kotlinx.serialization.Serializable

sealed class Routs {
    @Serializable
    data object First: Routs()
    @Serializable
    data object Second: Routs()
}