package ru.luchkinds.jetpack_compose_sample.works

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.ServiceInfo
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import ru.luchkinds.jetpack_compose_sample.R
import ru.luchkinds.jetpack_compose_sample.domain.services.ISampleService
import javax.inject.Inject

@HiltWorker
class SampleExpeditedWorker @Inject constructor(
    private val service: ISampleService,
    context: Context,
    params: WorkerParameters
): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        try {
            setForeground(getForegroundInfo(applicationContext))
        } catch (e: Exception) {
            return Result.failure()
        }
        Log.d("SampleWorker", "some work!")
        service.loadRows().map {
            Log.d("SampleWorker", "id: ${it.id}, title: ${it.title}")
        }
        return Result.success()
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return getForegroundInfo(applicationContext)
    }
}

const val notificationId = 1

private fun getForegroundInfo(context: Context): ForegroundInfo {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        ForegroundInfo(
            notificationId,
            createNotification(context),
            ServiceInfo.FOREGROUND_SERVICE_TYPE_NONE
        )
    } else {
        ForegroundInfo(
            notificationId,
            createNotification(context),
        )
    }
}

private fun createNotification(context: Context): Notification {
    val chanelId = "main_chanel_id"
    val chanelName = "Main chanel"

    val notification = NotificationCompat.Builder(context, chanelId)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Some title")
        .setContentText("Some work")
        .setAutoCancel(true)
        .setOngoing(true)
        .setSilent(true)
        .build()

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val chanel = NotificationChannel(
        chanelId,
        chanelName,
        NotificationManager.IMPORTANCE_DEFAULT
    )
    notificationManager.createNotificationChannel(chanel)
    return notification
}