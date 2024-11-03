package ru.luchkinds.jetpack_compose_sample.domain.services

import kotlinx.coroutines.flow.Flow
import ru.luchkinds.jetpack_compose_sample.domain.entities.SampleEntity

interface ISampleService {
    // suspend fun loadRows(): Flow<List<SampleEntity>>
    suspend fun loadRows(): List<SampleEntity>
}