package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.component.HorizontalMovieListType.*

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun HorizontalMovieList(
    items: List<Movie>,
    modifier: Modifier = Modifier,
    title: String? = null,
    onItemClicked: (Movie) -> Unit = {},
    type: HorizontalMovieListType = PORTRAIT,
    paddingContent: Dp = 0.dp
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {

        if (!title.isNullOrBlank()) Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(start = 8.dp.plus(paddingContent), bottom = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(start = paddingContent, end = paddingContent)
        ) {
            items(items) { item ->
                when (type) {
                    PORTRAIT -> {
                        PortraitMovieItem(
                            movie = item,
                            modifier = Modifier.padding(start = 8.dp),
                            onItemClicked = { onItemClicked.invoke(item) })
                    }
                    ROUNDED -> {
                        RoundedMovieItem(
                            movie = item,
                            modifier = Modifier.padding(start = 8.dp),
                            onItemClicked = { onItemClicked.invoke(item) })
                    }
                    LANDSCAPE -> {
                        LandscapeMovieItem(
                            movie = item,
                            modifier = Modifier.padding(start = 8.dp),
                            onItemClicked = { onItemClicked.invoke(item) })
                    }
                }
            }
        }
    }
}

enum class HorizontalMovieListType { PORTRAIT, LANDSCAPE, ROUNDED }

@Preview("Rounded List")
@Composable
fun PreviewRoundedMovieList() {
    val movies = remember {
        listOf(
            Movie(
                1,
                "Herooooo",
                "asd",
                "https://i.picsum.photos/id/513/200/200.jpg",
                "https://i.picsum.photos/id/513/200/200.jpg"
            )
        )
    }

    HorizontalMovieList(
        items = movies + movies + movies,
        title = "Popular Shows",
        type = ROUNDED,
        paddingContent = 8.dp
    )
}

@Preview("Portrait List")
@Composable
fun PreviewPortraitMovieList() {
    val movies = remember {
        listOf(
            Movie(
                1,
                "Herooooo",
                "asd",
                "https://i.picsum.photos/id/513/200/200.jpg",
                "https://i.picsum.photos/id/513/200/200.jpg"
            )
        )
    }

    HorizontalMovieList(
        items = movies + movies + movies,
        title = "Popular Shows",
        type = PORTRAIT,
        paddingContent = 8.dp
    )
}

@Preview("Landscape List")
@Composable
fun PreviewLandscapeMovieList() {
    val movies = remember {
        listOf(
            Movie(
                1,
                "Herooooo",
                "asd",
                "https://i.picsum.photos/id/513/200/200.jpg",
                "https://i.picsum.photos/id/513/200/200.jpg"
            )
        )
    }

    HorizontalMovieList(
        items = movies + movies + movies,
        title = "Popular Shows",
        type = LANDSCAPE,
        paddingContent = 8.dp
    )
}