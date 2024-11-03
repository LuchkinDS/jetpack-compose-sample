package ru.luchkinds.jetpack_compose_sample.data.services

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.luchkinds.jetpack_compose_sample.common.toSampleEntity
import ru.luchkinds.jetpack_compose_sample.data.remote.SampleRemote
import ru.luchkinds.jetpack_compose_sample.domain.entities.SampleEntity
import ru.luchkinds.jetpack_compose_sample.domain.services.ISampleService
import javax.inject.Inject

class SampleService @Inject constructor(
    private val sampleRemote: SampleRemote
): ISampleService {
    // override suspend fun loadRows(): Flow<List<SampleEntity>> {
    override suspend fun loadRows(): List<SampleEntity> {
        val result =  sampleRemote.loadRows().map {
            it.toSampleEntity()
        }
        return result
        /*
        return flow {
            emit(result)
        }

         */
    }
}
