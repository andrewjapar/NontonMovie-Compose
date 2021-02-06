package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.andrewjap.nontonmovie.domain.entity.Genre
import dev.andrewjap.nontonmovie.presentation.ui.theme.NontonMovieShapes

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalFoundationApi
@Composable
fun GridGenreList(
    items: List<Genre>,
    modifier: Modifier = Modifier,
    onItemClicked: (Genre) -> Unit = {}
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        items(items) { item ->
            GenreItem(
                genre = item,
                onItemClicked = onItemClicked,
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

@Composable
private fun GenreItem(
    genre: Genre,
    onItemClicked: (Genre) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .aspectRatio(1.77f)
                .align(Alignment.CenterHorizontally)
                .clip(NontonMovieShapes.small)
                .background(Brush.horizontalGradient(listOf(Color(23, 39, 89), Color(40, 72, 157))))
                .clickable { onItemClicked.invoke(genre) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.75f)),
                            0f,
                            500f
                        )
                    )
            )

            Text(
                text = genre.name,
                color = Color.White,
                maxLines = 1,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview("Grid List")
@Composable
fun PreviewGridMovieList() {
    val genres = remember {
        listOf(
            Genre(
                1,
                "Herooooo"
            )
        )
    }

    GridGenreList(
        items = genres + genres + genres
    )
}