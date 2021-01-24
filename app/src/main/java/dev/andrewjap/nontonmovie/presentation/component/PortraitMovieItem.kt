package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Film
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun PortraitMovieItem(
    movie: Film,
    onItemClicked: (Film) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.75f)
                .align(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.small)
                .background(Color.Gray)
                .clickable { onItemClicked.invoke(movie) }
        ) {
            CoilImage(
                data = movie.portraitImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun PreviewPortraitMovieItem() {
    val movie = remember {
        Film.Movie(
            1,
            "Herooooo",
            "asd",
            "https://i.picsum.photos/id/513/200/200.jpg",
            "https://i.picsum.photos/id/513/200/200.jpg"
        )
    }
    PortraitMovieItem(
        movie = movie,
        onItemClicked = {},
        modifier = Modifier.preferredHeight(100.dp)
    )
}