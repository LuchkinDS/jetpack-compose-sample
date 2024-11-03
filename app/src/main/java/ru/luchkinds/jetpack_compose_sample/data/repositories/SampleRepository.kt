package ru.luchkinds.jetpack_compose_sample.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.luchkinds.jetpack_compose_sample.common.toSampleEntity
import ru.luchkinds.jetpack_compose_sample.data.db.SampleDao
import ru.luchkinds.jetpack_compose_sample.domain.entities.SampleEntity
import ru.luchkinds.jetpack_compose_sample.domain.repositories.ISampleRepository
import javax.inject.Inject

class SampleRepository @Inject constructor(
    private val dao: SampleDao
): ISampleRepository {
    override suspend fun getRows(): Flow<List<SampleEntity>> {

        val result = dao.getRows().map {
            it.toSampleEntity()
        }
        return flow {
            emit(result)
        }
    }

    override suspend fun getRowById(id: Long): SampleEntity {
        return dao.getRowBtId(id).toSampleEntity()
    }
}
