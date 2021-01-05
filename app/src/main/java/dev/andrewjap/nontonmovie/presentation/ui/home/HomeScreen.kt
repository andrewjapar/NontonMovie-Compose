package dev.andrewjap.nontonmovie.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie

@Composable
fun HomeScreen(
    movies: List<Movie>
) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        LazyColumn {
            items(movies) { movie ->
                PortraitMovieRow(movie = movie, onItemClicked = { })
            }
        }
    }
}

@Composable
fun PortraitMovieRow(
    movie: Movie,
    onItemClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .clickable { onItemClicked.invoke(movie) }
            .padding(4.dp),
    ) {
        Text(
            text = movie.name
        )
    }
}

@Preview
@Composable
fun PreviewPortraitRow() {
    val movie = remember { Movie(1, "Heroo", "image") }
    PortraitMovieRow(movie = movie, onItemClicked = {}, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewPortraitList() {
    val movies = remember { listOf(Movie(1, "Heroo", "image"), Movie(2, "Heroik", "image")) }
    HomeScreen(movies = movies)
}