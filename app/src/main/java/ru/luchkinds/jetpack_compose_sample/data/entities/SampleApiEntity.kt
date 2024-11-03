package ru.luchkinds.jetpack_compose_sample.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// import com.google.gson.annotations.SerializedName

@Serializable
data class SampleApiEntity(
    // @SerializedName("id")
    @SerialName("id")
    val id: Long,

    //@SerializedName("userId")
    @SerialName("userId")
    val userId: Long,

    @SerialName("title")
    val title: String,

    @SerialName("body")
    val content: String
)
