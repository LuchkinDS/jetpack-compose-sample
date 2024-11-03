package ru.luchkinds.jetpack_compose_sample.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.luchkinds.jetpack_compose_sample.domain.entities.SampleEntity

interface ISampleRepository {
    suspend fun getRows(): Flow<List<SampleEntity>>
    suspend fun getRowById(id: Long): SampleEntity
}