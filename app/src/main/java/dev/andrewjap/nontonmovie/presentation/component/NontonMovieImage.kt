package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun NontonMovieImage(
    data: Any,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    fadeIn: Boolean = false,
) {
    CoilImage(
        data = data,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier,
        colorFilter = colorFilter,
        fadeIn = fadeIn
    )
}