package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.home.Screen
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun MainApp(
    homeViewModel: HomeViewModel
) {
    Crossfade(current = homeViewModel.currentScreen) { screen ->
        when (screen) {
            Screen.Home -> MainScreen(
                homeViewModel = homeViewModel,
                navigateTo = homeViewModel::navigateTo
            )
            else -> TestScreen(
                navigateTo = homeViewModel::navigateTo
            )
        }
    }
}