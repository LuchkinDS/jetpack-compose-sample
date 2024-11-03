package ru.luchkinds.jetpack_compose_sample.domain.entities

import android.icu.text.CaseMap.Title

data class SampleEntity(
    val id: Long,
    val userId: Long,
    val title: String,
    val content: String,
)