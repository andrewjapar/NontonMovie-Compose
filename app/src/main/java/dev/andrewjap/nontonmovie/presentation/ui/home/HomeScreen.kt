package dev.andrewjap.nontonmovie.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.domain.entity.Movie

@Composable
fun HomeScreen(
    movies: List<Movie>
) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        SwipeToRefreshLayout(
            refreshingState = true,
            onRefresh = {},
            refreshIndicator = {
                Surface(elevation = 10.dp, shape = CircleShape) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .preferredSize(36.dp)
                            .padding(4.dp)
                    )
                }
            }) {
            LazyColumn {
                items(movies) { movie ->
                    PortraitMovieRow(movie = movie, onItemClicked = { })
                }
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
    Column(
        modifier
            .clickable { onItemClicked.invoke(movie) }
            .padding(4.dp),
    ) {
        Text(
            text = movie.name
        )
        CoilImage(
            imageModel = movie.image,
            contentScale = ContentScale.Crop,
            modifier = modifier,
            placeHolder = imageResource(R.drawable.website),
            error = imageResource(R.drawable.website)
        )
        Text(
            text = movie.name
        )
    }
}

@Preview
@Composable
fun PreviewPortraitRow() {
    val movie = remember {
        Movie(
            1,
            "Herooooo",
            "https://i.insider.com/5f5761f9e6ff30001d4e7665?width=1100&format=jpeg"
        )
    }
    PortraitMovieRow(movie = movie, onItemClicked = {}, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewPortraitList() {
    val movies = remember { listOf(Movie(1, "Heroo", "image"), Movie(2, "Heroik", "image")) }
    HomeScreen(movies = movies)
}