package dev.andrewjap.nontonmovie.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.component.HeadlineMovieSlider
import dev.andrewjap.nontonmovie.presentation.ui.home.component.PortraitMovieItem

@Composable
fun HomeScreen(
    movies: List<Movie>
) {
    WithConstraints {
        val boxWidth = with(AmbientDensity.current) { constraints.maxWidth.toDp() }

        ScrollableColumn(
            Modifier.fillMaxWidth()
        ) {

            HeadlineMovieSlider(
                items = movies,
                modifier = Modifier
                    .padding(start = 24.dp, top = 16.dp, end = 24.dp)
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            LazyRow {
                items(movies) { movie ->
                    PortraitMovieItem(movie = movie, onItemClicked = { Log.d("testo", "asdsd") })
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    val movies = remember { listOf(Movie(1, "Heroo", "image"), Movie(2, "Heroik", "image")) }
    HomeScreen(movies = movies)
}