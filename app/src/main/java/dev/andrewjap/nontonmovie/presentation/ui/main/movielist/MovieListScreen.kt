package dev.andrewjap.nontonmovie.presentation.ui.main.movielist

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import dev.andrewjap.nontonmovie.presentation.component.HeadlineMovieSlider
import dev.andrewjap.nontonmovie.presentation.component.HorizontalMovieList
import dev.andrewjap.nontonmovie.presentation.component.HorizontalMovieListType
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = viewModel()
) {

    val viewState by viewModel.showMovies.collectAsState()

    if (viewState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        return
    }

    BoxWithConstraints {
        val boxWidth = with(AmbientDensity.current) { constraints.maxWidth.toDp() }

        ScrollableColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            HeadlineMovieSlider(
                items = viewState.nowPlaying,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            HorizontalMovieList(
                items = viewState.upcoming,
                title = "Upcoming Movies",
                type = HorizontalMovieListType.ROUNDED,
                paddingContent = 8.dp
            )

            HorizontalMovieList(
                items = viewState.latest,
                title = "Top Rated Movies",
                paddingContent = 8.dp,
                type = HorizontalMovieListType.LANDSCAPE,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(
                        boxWidth
                            .div(3)
                            .div(0.67f)
                    )
            )

            HorizontalMovieList(
                items = viewState.popular,
                title = "Popular Movies",
                paddingContent = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(
                        boxWidth
                            .div(3)
                            .div(0.67f)
                    )
            )
        }
    }
}