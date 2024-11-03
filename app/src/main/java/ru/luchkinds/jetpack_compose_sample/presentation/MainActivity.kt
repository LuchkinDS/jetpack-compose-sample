package ru.luchkinds.jetpack_compose_sample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.AndroidEntryPoint
import ru.luchkinds.jetpack_compose_sample.navigation.SampleNavigation
import ru.luchkinds.jetpack_compose_sample.ui.theme.JetpackComposeSimpleSkeletonTheme
import ru.luchkinds.jetpack_compose_sample.works.SampleWorker
import java.time.Duration

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val workRequest = OneTimeWorkRequestBuilder<SampleWorker>().apply {
            setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofMinutes(1))
            setConstraints(Constraints(NetworkType.CONNECTED))
        }.build()

        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueueUniqueWork(
            "one_time_sample_work",
            ExistingWorkPolicy.KEEP,
            workRequest,
        )


        setContent {
            JetpackComposeSimpleSkeletonTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SampleNavigation(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        firstScreenContent = {
                            Greeting()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "First Screen"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeSimpleSkeletonTheme {
        Greeting()
    }
}