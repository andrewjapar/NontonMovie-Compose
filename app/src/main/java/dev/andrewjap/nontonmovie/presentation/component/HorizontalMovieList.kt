package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Film
import dev.andrewjap.nontonmovie.presentation.component.HorizontalMovieListType.*

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun HorizontalMovieList(
    items: List<Film>,
    modifier: Modifier = Modifier,
    title: String? = null,
    onItemClicked: (Film) -> Unit = {},
    type: HorizontalMovieListType = PORTRAIT,
    height: Dp = 180.dp,
    paddingContent: Dp = 0.dp
) {

    if (items.isEmpty()) return

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {

        val listModifier = remember {
            if (type == ROUNDED) Modifier
            else Modifier.preferredHeight(height)
        }

        if (!title.isNullOrBlank()) Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(start = 8.dp.plus(paddingContent), bottom = 8.dp)
        )

        LazyRow(
            modifier = listModifier,
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
            Film.Movie(
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
            Film.Movie(
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
            Film.Movie(
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