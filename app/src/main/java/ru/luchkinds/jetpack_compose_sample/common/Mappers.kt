package ru.luchkinds.jetpack_compose_sample.common

import ru.luchkinds.jetpack_compose_sample.data.entities.SampleApiEntity
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleDbEntity
import ru.luchkinds.jetpack_compose_sample.domain.entities.SampleEntity

fun SampleDbEntity.toSampleEntity(): SampleEntity {
    return SampleEntity(
        id = id,
        userId = userId,
        title = title,
        content = content,
    )
}

fun SampleApiEntity.toSampleEntity(): SampleEntity {
    return SampleEntity(
        id = id,
        userId = userId,
        title = title,
        content = content,
    )
}
