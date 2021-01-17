package dev.andrewjap.nontonmovie.presentation.ui.home.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                            onItemClicked = { Log.d("testo", "Horizontal") })
                    }
                    ROUNDED -> {
                        RoundedMovieItem(
                            movie = item,
                            modifier = Modifier.padding(start = 8.dp),
                            onItemClicked = { Log.d("testo", "Horizontal") })
                    }
                    LANDSCAPE -> {
                        LandscapeMovieItem(
                            movie = item,
                            modifier = Modifier.padding(start = 8.dp),
                            onItemClicked = { Log.d("testo", "Horizontal") })
                    }
                }
            }
        }
    }
}

enum class HorizontalMovieListType { PORTRAIT, LANDSCAPE, ROUNDED }