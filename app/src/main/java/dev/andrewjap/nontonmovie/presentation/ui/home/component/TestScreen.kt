package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dev.andrewjap.nontonmovie.presentation.ui.home.Screen

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun TestScreen(
    navigateTo: (Screen) -> Unit
) {
    Box {
        Text(text = "Hello World")
    }
}