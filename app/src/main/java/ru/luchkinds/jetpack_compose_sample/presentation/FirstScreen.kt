package ru.luchkinds.jetpack_compose_sample.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    modifier: Modifier,
    content: @Composable () -> Unit,
    onClickHandler: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        content()
        Column {
            Button(
                onClick = { onClickHandler() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            {
                Text(text = "Go to Next Screen")
            }
        }
    }
}