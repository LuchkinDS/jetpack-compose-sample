package ru.luchkinds.jetpack_compose_sample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.luchkinds.jetpack_compose_sample.presentation.FirstScreen
import ru.luchkinds.jetpack_compose_sample.presentation.SecondScreen

@Composable
fun SampleNavigation(
    modifier: Modifier,
    navController: NavHostController,
    firstScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Routs.First,
    ) {
        composable<Routs.First> {
            FirstScreen(
                modifier = modifier,
                content = firstScreenContent,
                onClickHandler = { navController.navigate(Routs.Second) },
            )
        }
        composable<Routs.Second> {
            SecondScreen(
                modifier = modifier,
                onClickHandler = { navController.navigate(Routs.First) })
        }
    }
}





