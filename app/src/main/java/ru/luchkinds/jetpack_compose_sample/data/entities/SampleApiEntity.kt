package ru.luchkinds.jetpack_compose_sample.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// import com.google.gson.annotations.SerializedName

@Serializable
data class SampleApiEntity(
    // @SerializedName("id")
    @SerialName("id")
    val id: Int,

    //@SerializedName("userId")
    @SerialName("userId")
    val userId: Int,
)
