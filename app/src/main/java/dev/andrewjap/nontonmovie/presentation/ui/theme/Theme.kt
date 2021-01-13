package dev.andrewjap.nontonmovie.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun NontonMovieTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = NontonMovieColors,
        typography = NontonMovieTypography,
        shapes = NontonMovieShapes,
        content = content
    )
}