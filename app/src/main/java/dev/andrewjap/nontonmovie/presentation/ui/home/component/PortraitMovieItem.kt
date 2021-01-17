package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.chrisbanes.accompanist.glide.GlideImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun PortraitMovieItem(
    movie: Movie,
    onItemClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.75f)
                .align(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.small)
                .clickable { onItemClicked.invoke(movie) }
        ) {
            GlideImage(
                data = movie.portraitImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}