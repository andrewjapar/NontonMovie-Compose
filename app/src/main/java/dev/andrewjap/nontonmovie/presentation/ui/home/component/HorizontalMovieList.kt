package dev.andrewjap.nontonmovie.presentation.ui.home.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun HorizontalMovieList(
    items: List<Movie>,
    modifier: Modifier = Modifier,
    title: String? = null,
    paddingContent: Dp = 0.dp
) {
    Column(modifier = modifier) {

        if (!title.isNullOrBlank()) Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp.plus(paddingContent))
        )

        LazyRow(
            contentPadding = PaddingValues(start = paddingContent, end = paddingContent)
        ) {
            items(items) { item ->
                PortraitMovieItem(
                    movie = item,
                    modifier = Modifier.padding(start = 4.dp),
                    onItemClicked = { Log.d("testo", "Horizontal") })
            }
        }
    }
}