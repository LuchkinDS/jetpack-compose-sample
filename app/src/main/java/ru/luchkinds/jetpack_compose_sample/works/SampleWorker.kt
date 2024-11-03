package ru.luchkinds.jetpack_compose_sample.works

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import ru.luchkinds.jetpack_compose_sample.domain.services.ISampleService
import javax.inject.Inject

@HiltWorker
class SampleWorker @Inject constructor(
    private val service: ISampleService,
    context: Context,
    params: WorkerParameters
): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        Log.d("SampleWorker", "some work!")
        service.loadRows().map {
            Log.d("SampleWorker", "id: ${it.id}, title: ${it.title}")
        }
        return Result.success()
    }
}