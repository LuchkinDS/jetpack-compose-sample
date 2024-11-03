package ru.luchkinds.jetpack_compose_sample.di

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import ru.luchkinds.jetpack_compose_sample.works.SampleExpeditedWorkerFactory
import javax.inject.Inject

@HiltAndroidApp
class App: Application(), Configuration.Provider {
    @Inject lateinit var sampleWorkerFactory: SampleExpeditedWorkerFactory
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(sampleWorkerFactory)
            .build()
}