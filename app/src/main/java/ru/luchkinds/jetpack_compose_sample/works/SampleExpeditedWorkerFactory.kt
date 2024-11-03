package ru.luchkinds.jetpack_compose_sample.works

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import ru.luchkinds.jetpack_compose_sample.domain.services.ISampleService
import javax.inject.Inject

class SampleExpeditedWorkerFactory @Inject constructor(
    private val service: ISampleService
): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker = SampleExpeditedWorker(service, appContext, workerParameters)
}