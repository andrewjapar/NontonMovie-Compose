package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.chrisbanes.accompanist.glide.GlideImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun LandscapeMovieItem(
    movie: Movie,
    onItemClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .clickable { onItemClicked.invoke(movie) }
            .padding(4.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1.77f)
                .align(Alignment.CenterHorizontally)
        ) {
            GlideImage(
                data = movie.image,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.small)
            )
        }
    }
}

@Preview
@Composable
fun PreviewLandscapeMovieItem() {
    val movie = remember {
        Movie(
            1,
            "Herooooo",
            "https://i.insider.com/5f5761f9e6ff30001d4e7665?width=1100&format=jpeg"
        )
    }
    LandscapeMovieItem(movie = movie, onItemClicked = {}, modifier = Modifier.fillMaxWidth())
}